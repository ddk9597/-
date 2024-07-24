package com.kch.study.realtor.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kch.study.realtor.member.model.dto.rMember;

@Mapper
public interface rMemberMapper {
	
	// 회원가입하기
	int signUp(rMember inputMember);

	// 입력된 이메일 중복 확인하기
	int checkEmail(String memberEmail);


	
}
