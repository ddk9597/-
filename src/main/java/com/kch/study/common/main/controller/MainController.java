package com.kch.study.common.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // bean 등록하여 springContainer가 생성하고 관리하게 함
public class MainController {

	@RequestMapping("/") // "/" 요청을 매핑(모든 메서드에 대해서 실행됨)
	public String mainPage() {

		// common/main.html로 forward
		return "common/main";
	}
	
	@GetMapping("/realtorSearch/rSearch")
	public String realtorSearch() {
		return "realtorSearch/rSearch";
	}

	@GetMapping("/realtor/rMain")
	public String showRealtorMain() {
		return "realtor/rMain";
	}
}
