package com.kch.study.realtor.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.member.model.service.rMemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("realtor/member")
@RequiredArgsConstructor
@Slf4j
public class rMemberController {

	private final rMemberService service;
	private final PasswordEncoder passwordEncoder;

	// 이메일 중복 검사
	@ResponseBody
	@GetMapping("checkEmail")
	public int checkEmail(@RequestParam("memberEmail") String memberEmail) {
		log.info("memberEmail : " + memberEmail);
		return service.checkEmail(memberEmail);
	}

	// 인증 메일 보내기
	@ResponseBody
	@PostMapping("sendAuthKey")
	public int sendAuthKey(@RequestBody Map<String, String> request) {
		String memberEmail = request.get("memberEmail");
		String htmlName = request.get("htmlName");

		String authKey = service.sendAuthKey(memberEmail, htmlName);

		if (authKey != null) {
			return 1;
		}
		// 인증메일 보내기 실패
		return 0;
	}

	@ResponseBody
	@PostMapping("checkAuthKey")
	public int checkAuthKey(@RequestBody Map<String, Object> map) {
		return service.checkAuthKey(map);
	}

	// 회원 가입
	@ResponseBody
	@PostMapping("signUp")
	public int signUp(@RequestBody rMember inputMember) {
		return service.signUp(inputMember);
	}

	// 로그인하기
	@PostMapping("login")
	public String login(@RequestParam(name = "memberEmail") String email,
	                    @RequestParam(name = "inputPw") String inputPw, Model model,
	                    HttpServletRequest request) {
	    log.info("로그인 시도: {}", email);

	    // 입력한 이메일로 가입한 아이디가 있는지 확인
	    int checkEmail = service.checkLoginEmail(email);

	    if (checkEmail != 1) {
	        log.warn("이메일 없음: {}", email);
	        model.addAttribute("errorMessage", "이메일을 확인해 주세요.");
	        return "realtor/member/login";
	    } else {
	        Map<String, Object> map = new HashMap<>();
	        map.put("memberEmail", email);
	        map.put("inputPw", inputPw);

	        boolean isPasswordCorrect = service.checkLoginPw(map);

	        if (isPasswordCorrect) {
	            rMember memberInfo = service.getMemberInfoByEmail(email); // 회원 정보를 가져오는 서비스 메서드

	            HttpSession session = request.getSession();
	            session.setAttribute("loginMember", memberInfo);
	            log.info("로그인 성공: {}", email);
	            return "redirect:/rMain";
	        } else {
	            log.warn("비밀번호 불일치: {}", email);
	            model.addAttribute("errorMessage", "비밀번호를 확인해 주세요.");
	            return "realtor/member/login";
	        }
	    }
	}
	
	
}
