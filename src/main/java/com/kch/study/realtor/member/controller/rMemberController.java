package com.kch.study.realtor.member.controller;

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
			@RequestParam(name = "inputPw") String inputPw, Model model) {

		// 입력한 이메일로 가입한 아이디가 있는지 확인
		int checkEmail = service.checkLoginEmail(email);

		// 입력한 이메일로 가입한 아이디 없음
		if (checkEmail != 1) {
			model.addAttribute("errorMessage", "이메일을 확인해 주세요.");
			return "login"; // 로그인 페이지로 돌아감
		} else {
			Map<String, Object> map;
			map.put("memberEmail", email);
			map.put("inputPw", inputPw);
			
			int checkPw = service.checkLoginPw(map);
			
			if (user != null && passwordEncoder.matches(inputPw, user.getEncryptedPassword())) {
				model.addAttribute("message", "로그인 성공!");
				return "welcome"; // 로그인 성공 시 보여줄 페이지
			} else {
				model.addAttribute("errorMessage", "비밀번호를 확인해 주세요.");
				return "login"; // 비밀번호가 틀릴 경우 다시 로그인 페이지로
			}
		}
	}
}
