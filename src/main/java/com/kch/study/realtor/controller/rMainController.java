package com.kch.study.realtor.controller;

import java.lang.reflect.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Integer loginMember = (Integer) session.getAttribute("loginMember");
        
        if (loginMember != null) {
            model.addAttribute("loginMember", loginMember);
        } else {
            // 로그인되지 않은 상태 처리
            model.addAttribute("loginMember", null);
        }
        
        return "realtor/rMain";
    }
	
	
	// 회원가입 페이지로 이동하기
	@GetMapping("member/join")
	public String toRealtorJoin() {
		return "realtor/member/join";
	}
	
	// 로그인 페이지로 이동하기
	@GetMapping("member/login")
	public String getLogin() {
		return "realtor/member/login";
	}
	
}
