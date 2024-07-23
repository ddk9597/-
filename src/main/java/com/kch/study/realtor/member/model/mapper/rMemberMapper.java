package com.kch.study.realtor.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface rMemberMapper {

	// 입력된 이메일 중복 확인하기
	int checkEmail(String memberEmail);

	
}
