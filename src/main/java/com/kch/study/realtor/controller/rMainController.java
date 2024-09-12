package com.kch.study.realtor.controller;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;
import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.model.service.rServiceImpl;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rMain")
@Controller
public class rMainController {

	private final rServiceImpl service;

	// 메인 페이지로 이동하기
	@GetMapping
	public String mainPage(Model model, HttpSession session) {
		rMember loginMember = (rMember) session.getAttribute("loginMember");
		model.addAttribute("loginMember", loginMember);
		return "realtor/rMain";
	}

	// 회원가입 페이지로 이동하기
	@GetMapping("member/join")
	public String toRealtorJoin() {
		return "realtor/member/join";
	}

	// 매물 목록 페이지로 이동하기
	@GetMapping("list")
	public String toList(Model model, HttpSession session) {
		rMember loginMember = (rMember) session.getAttribute("loginMember");
		model.addAttribute("loginMember", loginMember);

		// 매물 목록 가져오기
		List<ProductInfoDTO> productList = service.getProductList();

		// 매물별로 번호를 추출해서
		for (ProductInfoDTO product : productList) {
			int prdNo = product.getPropertiesNo();

			// 추출된 매물별 사진의 목록 가져오기
			List<String> prdPhotoList = service.getPrdPhotoList(prdNo);

			// 가져온 사진 목록을 model에 저장하기
			if (prdPhotoList != null && !prdPhotoList.isEmpty()) {
				product.setImageList(prdPhotoList);
			} else {
				// 사진 목록이 없는 경우를 처리 (옵션)
				product.setImageList(Collections.emptyList());
			}

		}

		// 모델에 매물 목록 추가
		model.addAttribute("productList", productList);

		return "realtor/list/list";
	}

	// 로그인 페이지로 이동하기
	@GetMapping("member/login")
	public String getLogin() {
		return "realtor/member/login";
	}

	// 로그아웃 실행하기
	@GetMapping("member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginMember");
		return "redirect:/rMain";
	}

	// 중개사회원의 매물 등록 페이지로 이동하기
	@GetMapping("product/register")
	public String toRegister(Model model, HttpSession session, HttpServletResponse response) throws IOException {
		rMember loginMember = (rMember) session.getAttribute("loginMember");

		if (loginMember == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인이 필요합니다.");
			return null;
		}

		int memberKind = loginMember.getMemberKind();
		// 3 : 중개사 회원만 접근 가능
		if (memberKind != 3) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "중개사 회원만 이용 가능합니다.");
			return null;
		}

		model.addAttribute("loginMember", loginMember);
		return "realtor/list/addList";
	}
}
