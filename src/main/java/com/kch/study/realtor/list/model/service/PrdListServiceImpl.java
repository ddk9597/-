package com.kch.study.realtor.list.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;
import com.kch.study.realtor.list.model.mapper.PrdListMapper;
import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.model.dto.GetDetailDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrdListServiceImpl implements PrdListService {

	private final PrdListMapper mapper;

	@Override
	public int addList(ProductInfoDTO productInfo) {

		int result = mapper.addList(productInfo);

		return result;
	}
	
	@Override
	public int addNoteForCustomer(Map<String, Object> map) {
		int result = mapper.addNoteForCustomer(map);
		return result;
	}

	@Override
	public int getThisProductNo(int memberNo) {

		return mapper.getThisProductNo(memberNo);
	}

	// 등록한 사진의 이름을 db에 저장하기
	@Override
	public void listUpPhoto(Integer thisProductNo, List<String> photoList) {
		// photoList를 문자열로 변환
		String photoListString = String.join(", ", photoList);

		// map에 변환된 문자열로 저장
		Map<String, Object> map = new HashMap<>();
		map.put("thisProductNo", thisProductNo);
		map.put("photoList", photoListString);

		mapper.listUpPhoto(map);
	}

	// 고객에게 보여줄 매물 정보 불러오기
	@Override
	public GetDetailDTO getDetailInfo(String productNo) {

		return mapper.getDetailInfo(productNo);
	}

	

}
