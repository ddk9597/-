package com.kch.study.realtor.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kch.study.realtor.member.model.service.rMemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("realtor/member")
@RequiredArgsConstructor
public class rMemberController {

	private final rMemberServiceImpl service;
	
	// 회원 가입하기
//	@PostMapping("join")
//	public String rJoi
	
	
}
