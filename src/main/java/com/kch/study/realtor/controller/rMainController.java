package com.kch.study.realtor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kch.study.realtor.model.service.rServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rMain")
@Controller
public class rMainController {

	private final rServiceImpl service;
	
	// 회원가입 페이지로 이동하기
	@GetMapping("member/join")
	public String getMethodName() {
		return "realtor/member/join";
	}
	
}
