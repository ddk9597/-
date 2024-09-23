package com.kch.study.realtor.contact.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kch.study.realtor.contact.model.dto.ContactDTO;

@Mapper
public interface ContactMapper {

	// 요청 등록하기
	int saveContactRequest(ContactDTO contactDTO);
	
	// 요청이 성공적으로 등록되면 contractProcess테이블에 추가하기
	int getContactNo();
	int addContractProcess(ContactDTO contactDTO);
	
	// 0->1 업데이트를 진행한다.
	int processUpdate(Map<String, Object> map);
	
	
	// 1->2 업데이트 진행
		// 현재 checker가 누군지 가져오기
		int getCurrentChecker(int contactNo);
		// 업데이트 진행
		int updateToTwo(Map<String, Object> map);


}
