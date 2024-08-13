package com.kch.study.realtor.list.model.service;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;

public interface PrdListService {

	// 게시글 등록하기
	int addList(ProductInfoDTO productInfo);

}
