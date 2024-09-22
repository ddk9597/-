package com.kch.study.realtor.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.contact.model.dto.ContactDTO;
import com.kch.study.realtor.contact.model.service.ContactService;
import com.kch.study.realtor.member.model.dto.rMember;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/realtor/contact")
public class ContactController {

	private final ContactService service;

	@PostMapping("/makeContactRequest")
	public String contact(RedirectAttributes ra, @ModelAttribute ContactDTO contactDTO, 
			@SessionAttribute(value = "loginMember", required = false) rMember loginMember) {
		
		int requester;
		
		// loginMember가 null인 경우 requester를 4로 설정
	    if (loginMember == null) {
	    	requester = -500;
	    } else {
	    	requester = loginMember.getMemberNo(); // loginMember가 null이 아닐 경우 memberNo 설정
	    }
		
	    contactDTO.setRequester(requester);
	    
		// contact 테이블에 데이터 산입
		int result = service.saveContactRequest(contactDTO); 
		String message = null;
		
		// contact, contactProcess 테이블에 삽입이 잘 되었다면
		if(result == 1) {
			
			message = "요청이 성공적으로 등록 되었습니다.";
		} else {
			message = "요청 등록 실패.. 관리자에게 문의하세요";
		}

		ra.addFlashAttribute("message", message);
		
		return "redirect:/rMain"; 
	}
	
	// contactProcess 상태 업데이트 하기
	// 접수한 contactNo = contactNo
	// curProcessStat : 현재 클릭한 매물의 접수 상태
	// status : 0: 접수 안함, 1: 접수함 : 2: 완료됨s
	// 업데이트한 회원의 번호 : loginMember.memberNo
	@PostMapping("/updateContactProcess")
	public String updateContactProcess(
	        @RequestParam int contactNo, 
	        RedirectAttributes ra, 
	        @SessionAttribute("loginMember") rMember loginMember,
	        ContactDTO contactDTO) {
		System.out.println("tlqkfhodksehla?");
		
	    if (loginMember == null) {
	        System.out.println("세션에 로그인 회원 정보가 없습니다.");
	    } else {
	        int memberNo = loginMember.getMemberNo();
	        System.out.println("업데이트 요청한 회원 : " + memberNo);
	    }

	    ra.addFlashAttribute("message", "청구 접수의 상태 업데이트");
	    return "redirect:/rMain/toContactList";
	}

	

}
