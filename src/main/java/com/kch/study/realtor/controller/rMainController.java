package com.kch.study.realtor.controller;

import java.lang.reflect.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.model.service.rServiceImpl;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rMain")
@Controller
public class rMainController {

	private final rServiceImpl service;

	// 메인 페이지로 이동하기
	@GetMapping
	public String mainPage(Model model, HttpSession session) {
		rMember loginMember = (rMember) session.getAttribute("loginMember");
		model.addAttribute("loginMember", loginMember);
		return "realtor/rMain";
	}

	// 회원가입 페이지로 이동하기
	@GetMapping("member/join")
	public String toRealtorJoin() {
		return "realtor/member/join";
	}

	// 매물 목록 페이지로 이동하기
	@GetMapping("list")
	public String toList(Model model, HttpSession session) {
		rMember loginMember = (rMember) session.getAttribute("loginMember");
		model.addAttribute("loginMember", loginMember);
		return "realtor/list/list";
	}

	// 로그인 페이지로 이동하기
	@GetMapping("member/login")
	public String getLogin() {
		return "realtor/member/login";
	}

	// 로그아웃 실행하기
	@GetMapping("member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginMember");
		return "redirect:/rMain";
	}

}
