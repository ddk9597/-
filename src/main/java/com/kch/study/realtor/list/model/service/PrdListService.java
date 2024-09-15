package com.kch.study.realtor.list.model.service;

import java.util.List;
import java.util.Map;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;
import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.model.dto.GetDetailDTO;

public interface PrdListService {

	// 게시글 등록하기
	int addList(ProductInfoDTO productInfo);
	
	// 고객에게 보여질 메모 등록
	int addNoteForCustomer(Map<String, Object> map);
	
	// 사진 등록을 위해 위에서 등록한 게시물의 번호 가져오기
	int getThisProductNo(int memberNo);

	// 등록한 사진의 이름을 db에 저장하기
	void listUpPhoto(Integer thisProductNo, List<String> photoList);

	// 고객에게 보여줄 매물 정보 불러오기
	GetDetailDTO getDetailInfo(String productNo);

	


}
