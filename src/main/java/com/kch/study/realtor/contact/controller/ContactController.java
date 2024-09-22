package com.kch.study.realtor.contact.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.kch.study.realtor.contact.model.mapper.ContactMapper;
import com.kch.study.realtor.contact.model.service.ContactService;
import com.kch.study.realtor.member.model.dto.rMember;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/realtor/contact")
public class ContactController {

	private final ContactService service;
	private final ContactMapper mapper;

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
		if (result == 1) {

			message = "요청이 성공적으로 등록 되었습니다.";
		} else {
			message = "요청 등록 실패.. 관리자에게 문의하세요";
		}

		ra.addFlashAttribute("message", message);

		return "redirect:/rMain";
	}

	// 중개사 회원만 접근 가능함
	// contactProcess 상태 업데이트 하기
	// 접수한 contactNo = contactNo
	// curProcessStat : 현재 클릭한 매물의 접수 상태
	// status : 0: 접수 안함, 1: 접수함 : 2: 완료됨s
	// 업데이트한 회원의 번호 : loginMember.memberNo
	@PostMapping("/updateContactProcess")
	public String updateContactProcess(
			@RequestParam(name = "contactNo") int contactNo,
			@RequestParam(name = "processStat") int processStat, 
			RedirectAttributes ra,
			@SessionAttribute("loginMember") rMember loginMember) {
		
		System.out.println("현재 접수 번호 : " + contactNo);
		System.out.printf("현재 processStat : " + processStat);
		
		String message = null;
		String path = null;
		int memberNo = loginMember.getMemberNo();
		// 중개사 회원만 조작 가능하게 함
		int memberKind = loginMember.getMemberKind();

		
		// 로그인 안된 경우
		if (loginMember == null) {
			System.out.println("세션에 로그인 회원 정보가 없습니다.");
		} else {
			
			// 로그인 되었고 중개사 회원이 아닌 경우
			if (memberKind != 3) {
				message = "중개사 회원만 이용 가능합니다.";
				path = "redirect:/rMain";
				
				// 중개사 회원인 경우
			} else {

				System.out.println("업데이트 요청한 중개사 회원 : " + memberNo);
				
				
				// 업데이트 진행 시 필요한 것 : 현재 회원 번호, 업데이트 할 contactNo
				
				Map<String, Object> map = new HashMap<>();
				map.put("contactNo", contactNo);
				map.put("memberNo", memberNo);

				// 업데이트를 진행한다.
				int processUpdate = service.processUpdate(map);
				
			}

		}

		ra.addFlashAttribute("message", message);
		return "redirect:/rMain/toContactList";
	}

}
