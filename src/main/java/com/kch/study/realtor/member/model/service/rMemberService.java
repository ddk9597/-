package com.kch.study.realtor.member.model.service;

import com.kch.study.realtor.member.model.dto.rMember;

public interface rMemberService {

	// 회원가입 서비스
	int signUp(rMember inputMember);
	
	// 회원 가입 시 입력한 이메일 확인하기
	int checkEmail(String memberEmail, String htmlName);

	String sendAuthKey(String memberEmail, String htmlName);



}
