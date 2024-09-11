package com.kch.study.realtor.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;

@Mapper
public interface rMapper {

	// 매물 목록 가져오기
	List<ProductInfoDTO> getProductList();

	
}
