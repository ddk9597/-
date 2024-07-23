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

@Controller
@RequestMapping("realtor/member")
@RequiredArgsConstructor
public class rMemberController {

	private final rMemberService service;

	// 회원 가입하기
	@PostMapping("signUp")
	public String signUp(rMember inputMember, RedirectAttributes ra) {
		// 로직을 여기에 추가하세요
		return null;
	}

	// 이메일 중복검사
	@ResponseBody
	@GetMapping("checkEmail")
	public int checkEmail(@RequestParam("memberEmail") String memberEmail) {
		return service.checkEmail(memberEmail);
	}
}
