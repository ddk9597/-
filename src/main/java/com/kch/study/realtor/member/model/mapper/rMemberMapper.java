package com.kch.study.realtor.member.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kch.study.realtor.member.model.dto.rMember;

@Mapper
public interface rMemberMapper {
	
	// 회원가입하기
	int signUp(rMember inputMember);

	// 입력된 이메일 중복 확인하기
	int checkEmail(String memberEmail);

	// 1차로 authKey테이블에 인증번호 저장
	int updateAuthKey(Map<String, String> map);

	// 2차로 인증번호 저장
	String insertAuthKey(Map<String, String> map);

	

	
}
