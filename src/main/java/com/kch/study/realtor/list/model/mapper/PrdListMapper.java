package com.kch.study.realtor.list.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;

@Mapper
public interface PrdListMapper {

	// 게시글 추가하기
	int addList(ProductInfoDTO productInfo);

}
