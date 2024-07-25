package com.kch.study.realtor.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.member.model.mapper.rMemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class rMemberServiceImpl implements rMemberService {

	private final rMemberMapper mapper;
	// 비크립트 암호화
	private final BCryptPasswordEncoder bcrypt;

	// 메일 보내기
	private final JavaMailSender mailSender;
	private final SpringTemplateEngine templateEngine;

	// 회원가입하기
	@Override
	public int signUp(rMember inputMember) {

		// 비밀번호 bycrypt 암호화
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		return mapper.signUp(inputMember);
	}

	// 회원 가입 시 이메일 확인하기
	@Override
	public int checkEmail(String memberEmail, String htmlName) {
		return mapper.checkEmail(memberEmail);
	}

	// 인증메일 보내기
	@Override
	public String sendAuthKey(String memberEmail, String htmlName) {

		String authKey = createAuthKey();
		
		try {
			String subject = null;
			switch(htmlName) {
			case "signUp" : subject =  "강찬혁의 가짜 부동산 사이트 인증번호입니다.";
			break;
			}
				
			}
			

		return null;
	}

	// 인증번호 생성
	public String createAuthKey() {

		String key = "";
		for (int i = 0; i < 5; i++) {

			int cel1 = (int) Math.random() * 3;

			if (cel1 == 0) {
				int num = (int) (Math.random() * 10);
				key += num;
			} else {
				// 영어알파벳 추가
				char ch = (char) (Math.random() * 26 + 65);
				int cel2 = (int) (Math.random() * 2);
				if (cel2 == 0) {
					ch = Character.toUpperCase(ch);
				}
				key += ch;

			}

		}

		return key;
	}

}
