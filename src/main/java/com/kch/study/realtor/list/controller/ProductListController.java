package com.kch.study.realtor.list.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kch.study.realtor.list.model.service.PrdListService;
import com.kch.study.realtor.list.model.service.PrdServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/realtor/list")
@Slf4j
public class ProductListController {
	
	private final PrdListService service;
	
	// 중개사가 게시물 등록하기
	@PostMapping("/addList")
	public String register(
		Model model,
		@RequestParam(value = "locationTitle") String locationTitle,
		@RequestParam(value = "addresNo") String addresNo,
		@RequestParam(value = "category") int category,
		@RequestParam(value = "isTenant") int isTenant,
		@RequestParam(value = "shopName") String shopName,
		@RequestParam(value = "contactWho") String contactWho,
		@RequestParam(value = "contactPhone") String contactPhone,
		@RequestParam(value = "floor") String floor,
		@RequestParam(value = "py") String py,
		@RequestParam(value = "premium", defaultValue="0") int premium,
		@RequestParam(value = "deposit", defaultValue="0") int deposit,
		@RequestParam(value = "rent", defaultValue="0") int rent,
		@RequestParam(value = "adminCost", defaultValue="0") int adminCost
		) {
		
		// 전달할 map 설정
		Map<String, Object> productInfo = new HashMap<>();
		
		productInfo.put(locationTitle, locationTitle.value)
		
		return "realtor/list/register";
	}
}
