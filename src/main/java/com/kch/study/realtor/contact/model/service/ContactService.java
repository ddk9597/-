package com.kch.study.realtor.contact.model.service;

import java.util.Map;

import com.kch.study.realtor.contact.model.dto.ContactDTO;

public interface ContactService {

	// 요청 등록하기
	int saveContactRequest(ContactDTO contactDTO);
	
	// 상태 업데이를 진행한다
	int processUpdate(Map<String, Object> map);
	

}
