package com.kch.study.realtor.list.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.list.model.dto.ProductInfoDTO;
import com.kch.study.realtor.list.model.service.PrdListService;
import com.kch.study.realtor.list.model.service.PrdServiceImpl;
import com.kch.study.realtor.member.model.dto.rMember;

import jakarta.servlet.http.HttpSession;
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
	public String register(Model model, ProductInfoDTO productInfo, RedirectAttributes ra, HttpSession session) {
		// 세션에서 loginMember 객체 가져오기
		rMember loginMember = (rMember) session.getAttribute("loginMember");

		if (loginMember == null) {
			// loginMember가 세션에 없으면 에러 페이지로 리다이렉트
			ra.addFlashAttribute("message", "로그인이 필요합니다.");
			return "redirect:/login"; // 로그인 페이지로 리다이렉트
		}

		// loginMember 객체에서 memberNo 추출
		int memberNo = loginMember.getMemberNo(); // rMember 클래스에 getMemberNo() 메서드가 있어야 합니다.

		productInfo.setMemberNo(memberNo);

		int result = service.addList(productInfo);

		if (result != 1) {
			ra.addFlashAttribute("message", "게시물 등록에 실패했습니다.");
			return "redirect:/realtor/list/register"; // 등록 페이지로 리다이렉트
		}

		ra.addFlashAttribute("message", "게시물이 성공적으로 등록되었습니다.");
		return "redirect:/realtor/list/success"; // 성공 페이지로 리다이렉트
	}

	// 사진 등록하기

	// 사진을 저장할 디렉토리 설정 : 절대경로로 설정
	private static final String UPLOADED_PATH = "src/main/resources/static/images/realtor/listPic/";

	@PostMapping("addPicture")
	public String addPicture(@RequestParam("picture") MultipartFile[] files, RedirectAttributes ra) {
		try {
			// 업로드된 파일을 저장하는 로직
			for (MultipartFile file : files) {
				// 원본 파일명 가져오기
				String fileName = file.getOriginalFilename();

				// 파일을 저장할 경로 설정
				File dest = new File(UPLOADED_PATH + fileName);

				// 파일 저장
				file.transferTo(dest);

				log.info("Uploaded file: " + fileName);
			}

			// 업로드 완료 메시지 설정
			ra.addFlashAttribute("message", "사진이 성공적으로 업로드되었습니다.");
		} catch (IOException e) {
			// 업로드 실패 시 오류 메시지 설정
			ra.addFlashAttribute("message", "사진 업로드 중 오류가 발생했습니다.");
			log.error("File upload error: " + e.getMessage());
		}

		// 업로드 후 리다이렉트할 페이지
		return "redirect:/realtor/list";
	}
}
