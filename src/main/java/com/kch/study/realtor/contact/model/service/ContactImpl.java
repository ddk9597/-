package com.kch.study.realtor.contact.model.service;

import org.springframework.stereotype.Service;

import com.kch.study.realtor.contact.model.dto.ContactDTO;
import com.kch.study.realtor.contact.model.mapper.ContactMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactImpl implements ContactService {

	private final ContactMapper mapper;
	
	// 요청 등록하기
	@Override
	public int saveContactRequest(ContactDTO contactDTO) {
		
		int result = mapper.saveContactRequest(contactDTO);
		
		return result;
	}
	
	
}
