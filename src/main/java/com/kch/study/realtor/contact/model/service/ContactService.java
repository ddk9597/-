package com.kch.study.realtor.contact.model.service;

import com.kch.study.realtor.contact.model.dto.ContactDTO;

public interface ContactService {

	// 요청 등록하기
	int saveContactRequest(ContactDTO contactDTO);

}
