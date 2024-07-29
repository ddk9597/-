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
	int updateAuthKey(Map<String, Object> map);

	// 2차로 인증번호 저장
	int insertAuthKey(Map<String, Object> map);

	// 입력한 인증메일이 보낸 인증메일과 동일한지 확인하기.
	int checkAuthKey(Map<String, Object> map);
	
	// 로그인시 입력한 이메일로 가입된 아이디 있는지 확인
	int checkLoginEmail(String email);
	
	// 저장된 비밀번호 가져오기
	String getStoredPassword(String email);

	

	
	

	
}
