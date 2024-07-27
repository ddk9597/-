package com.kch.study.realtor.member.model.service;

import java.util.Map;

import com.kch.study.realtor.member.model.dto.rMember;

public interface rMemberService {

	// 회원가입 서비스
	int signUp(rMember inputMember);
	

	// 회원 가입 시 입력한 이메일 확인하기
	int checkEmail(String memberEmail);

	// 인증메일 보내기
	String sendAuthKey(String memberEmail, String htmlName);

	// 입력한 인증메일이 보낸 인증메일과 동일한지 확인하기
	int checkAuthKey(Map<String, Object> map);




	





}
