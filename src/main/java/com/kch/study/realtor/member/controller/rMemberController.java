package com.kch.study.realtor.member.controller;

import java.lang.reflect.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.member.model.service.rMemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("realtor/member")
@RequiredArgsConstructor
public class rMemberController {

	private final rMemberServiceImpl service;
	
	// 회원 가입하기
	@PostMapping("signUp")
	public String signUp(
			rMember inputMember,
			RedirectAttributes ra
			) {
		
		return null;
	}
}
