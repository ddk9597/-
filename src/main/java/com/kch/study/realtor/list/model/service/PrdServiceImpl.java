package com.kch.study.realtor.list.model.service;

import org.springframework.stereotype.Service;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;
import com.kch.study.realtor.list.model.mapper.PrdListMapper;
import com.kch.study.realtor.member.model.dto.rMember;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrdServiceImpl implements PrdListService{

	private final PrdListMapper mapper;
	
	
	@Override
	public int addList(ProductInfoDTO productInfo) {
		
		int result = mapper.addList(productInfo);
		
		return result;
	}
	
	@Override
	public int getThisProductNo(int memberNo) {
		
		return mapper.getThisProductNo(memberNo);
	}
}
