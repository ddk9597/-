package com.kch.study.realtor.contact.model.service;

import java.util.Map;

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
		
		int result = 0;
		int saveContactRequest = mapper.saveContactRequest(contactDTO);
		if(saveContactRequest == 1) {
			int curContactNo = mapper.getContactNo();
			contactDTO.setContactNo(curContactNo);
			
			result = mapper.addContractProcess(contactDTO);
		}
		
		return result;
	}
	
	
	// 0 -> 1업데이트를 진행한다.
	@Override
	public int processUpdate(Map<String, Object> map) {
		
		int result = mapper.processUpdate(map);
		return 0;
	}
	
	// 1 -> 2 업데이트 진행
	@Override
	public int updateToTwo(Map<String, Object> map) {
		
		int result = mapper.updateToTwo(map);
		return 0;
	}
}
