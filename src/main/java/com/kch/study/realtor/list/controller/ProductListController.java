package com.kch.study.realtor.list.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	// 1. 게시물 내용 등록하기
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
		// rMember 클래스에 getMemberNo() 메서드를 이용함
		int memberNo = loginMember.getMemberNo();

		productInfo.setMemberNo(memberNo);

		int result = service.addList(productInfo);

		if (result != 1) {
			ra.addFlashAttribute("message", "게시물 등록에 실패했습니다.");
			return "redirect:/realtor/list/register"; // 등록 페이지로 리다이렉트
		}

		model.addAttribute("message", "게시물이 성공적으로 등록되었습니다.");
		int thisProductNo = service.getThisProductNo(memberNo);
		session.setAttribute("thisProductNo", thisProductNo); // 세션에 저장
		System.out.println("thisProductNo : " + thisProductNo);
		return "redirect:/realtor/list/showPostPhoto"; // 성공 페이지로 리다이렉트
	}

	// 사진 등록하기

	// 사진 등록 페이지로 이동하기
	@GetMapping("/showPostPhoto")
	public String showPostPhoto(Model model, HttpSession session, RedirectAttributes ra) {

		// 세션에서 loginMember 객체 가져오기
		rMember loginMember = (rMember) session.getAttribute("loginMember");

		if (loginMember == null) {
			// loginMember가 세션에 없으면 에러 페이지로 리다이렉트
			ra.addFlashAttribute("message", "로그인이 필요합니다.");
			return "redirect:/login"; // 로그인 페이지로 리다이렉트
		}

		Integer thisProductNo = (Integer) session.getAttribute("thisProductNo"); // 세션에서 값 읽기
		model.addAttribute("thisProductNo", thisProductNo); // 모델에 추가

		// 세션 -> 모델에 메세지 추가
		String message = (String) session.getAttribute("message");
		model.addAttribute("message", message);
		session.removeAttribute("message");

//		log.info("Login Member: {}", loginMember);
		return "realtor/list/postPhoto";
	}

	// 상대 경로 설정
	private static final Path UPLOADED_PATH = Paths.get("src/main/resources/static/images/realtor/listPic");

	@PostMapping("addPicture")
	public String addPicture(@RequestParam("pictures") MultipartFile[] files, RedirectAttributes ra,
			HttpSession session) {
		Integer thisProductNo = (Integer) session.getAttribute("thisProductNo");
		List<String> photoList = new ArrayList<>();

		try {
			if (!Files.exists(UPLOADED_PATH)) {
				Files.createDirectories(UPLOADED_PATH);
			}

			for (MultipartFile file : files) {
				if (file.isEmpty())
					continue;

				String originalFileName = file.getOriginalFilename();
				String newFileName = thisProductNo + "_" + originalFileName;
				Path destinationFile = UPLOADED_PATH.resolve(Paths.get(newFileName)).normalize().toAbsolutePath();

				try (InputStream inputStream = file.getInputStream()) {
					Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
				}

				photoList.add(newFileName);
			}

			// 서비스 호출로 데이터베이스에 파일 정보 저장
			service.listUpPhoto(thisProductNo, photoList);

			ra.addFlashAttribute("message", "사진이 성공적으로 업로드되었습니다.");
		} catch (IOException e) {
			ra.addFlashAttribute("message", "사진 업로드 중 오류가 발생했습니다.");
			e.printStackTrace();
		}

		return "redirect:/rMain/list";
	}

}
