package com.kch.study.common.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // bean 등록하여 springContainer가 생성하고 관리하게 함
public class MainController {

	@RequestMapping("/") // "/" 요청을 매핑(모든 메서드에 대해서 실행됨)
	public String mainPage() {

		// common/main.html로 forward
		return "common/main";
	}

	// 개업 공인중개사 검색기
	@GetMapping("/realtorSearch/rSearch")
	public String realtorSearch() {
		return "realtorSearch/rSearch";
	}

	// 가짜 부동산 중개 사이트로 이동
	@GetMapping("/realtor/rMain")
	public String getRMain() {
		return "realtor/rMain";
	}
	
	// 동호회 사이트로 이동
	@GetMapping("hg/main")
	public String getHgMain() {
		return "hg/main";
	}
	
}
