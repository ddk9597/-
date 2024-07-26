package com.kch.study.realtor.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.member.model.service.rMemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("realtor/member")
@RequiredArgsConstructor
@Slf4j
public class rMemberController {

	private final rMemberService service;

	// 회원 가입하기
	@PostMapping("signUp")
	public String signUp(rMember inputMember, RedirectAttributes ra) {

		int result = service.signUp(inputMember);

		String path = null;
		String message = null;

		// 회원가입 성공 시
		if (result > 0) {
			message = inputMember.getMemberName() + "님! 환영합니다!";
			path = "/";
		} else {
			message = " 회원가입 실패.";
			path = "signUp";
		}

		ra.addFlashAttribute("message", message);
		return "redirect:" + path;
	}

	// 이메일 중복검사
	@ResponseBody
	@GetMapping("checkEmail")
	public int checkEmail(@RequestParam("memberEmail") String memberEmail) {

		log.info("memberEmail : " + memberEmail);

		return service.checkEmail(memberEmail);
	}

	// 인증 메일 보내기
	@ResponseBody
	@PostMapping("checkEmail")
	public int sendAuthKey(@RequestParam("memberEmail") String memberEmail,
			String htmlName) {

//		String authKey = service.sendAuthKey(memberEmail);
		
		
		return 0;
	}
	
	
	
}
