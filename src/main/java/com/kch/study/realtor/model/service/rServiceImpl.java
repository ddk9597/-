package com.kch.study.realtor.model.service;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;
import com.kch.study.realtor.model.mapper.rMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class rServiceImpl implements rService {

	private final rMapper mapper;
	
	// 회원가입
	public int signUp(Member inputMember) {
		return 0;
	}

	// 매물 목록 가져오기
	public List<ProductInfoDTO> getProductList() {
		return mapper.getProductList();
	}

	// 매물에 맞는 사진 목록 가져오기
	public List<String> getPrdPhotoList(int prdNo) {
		return mapper.getPrdPhotoList(prdNo);
	}

	
}
