package com.kch.study.realtor.contact.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kch.study.realtor.contact.model.dto.ContactDTO;

@Mapper
public interface ContactMapper {

	// 요청 등록하기
	int saveContactRequest(ContactDTO contactDTO);
	
	// 요청이 성공적으로 등록되면 contractProcess테이블에 추가하기
	int getContactNo();
	int addContractProcess(ContactDTO contactDTO);



}
