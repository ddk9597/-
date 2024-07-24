package com.kch.study.realtor.member.controller;

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
		
		
		return null;
	}

	// 이메일 중복검사
	@ResponseBody
	@GetMapping("checkEmail")
	public int checkEmail(@RequestParam("memberEmail") String memberEmail) {
		
		log.info("memberEmail : " + memberEmail);
		
		return service.checkEmail(memberEmail);
	}
}
