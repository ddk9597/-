package com.kch.study.realtor.showList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kch.study.realtor.showList.model.service.ShowListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/realtor/showList")
public class ShowListController {

	private final ShowListService service;
	
	
	
}
