package com.kch.study.realtor.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kch.study.realtor.member.model.mapper.rMemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class rMemberServiceImpl implements rMemberService {

	private final rMemberMapper mapper;
	
	
	@Override
	public int checkEmail(String memberEmail) {
		return mapper.checkEmail(memberEmail);
	}

	
}
