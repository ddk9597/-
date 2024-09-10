package com.kch.study.realtor.list.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;
import com.kch.study.realtor.member.model.dto.rMember;

@Mapper
public interface PrdListMapper {

	// 게시글 추가하기
	int addList(ProductInfoDTO productInfo);

	// 사진 등록을 위해 위에서 등록한 게시물의 번호 가져오기
	int getThisProductNo(int memberNo);

}
