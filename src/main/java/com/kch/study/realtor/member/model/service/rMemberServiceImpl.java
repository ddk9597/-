package com.kch.study.realtor.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.member.model.mapper.rMemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class rMemberServiceImpl implements rMemberService {

	private final rMemberMapper mapper;
	
	@Autowired // byCrypt DI
	private BCryptPasswordEncoder bcrypt;
	
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
	public int checkEmail(String memberEmail) {
		return mapper.checkEmail(memberEmail);
	}

	
}
