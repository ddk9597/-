package com.kch.study.realtor.list.controller;

import java.io.File;
import java.io.IOException;
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

	// 사진을 저장할 디렉토리 : 절대경로로 설정
	private static final String UPLOADED_PATH = "C:/Users/Galaxy Book Pro/Desktop/project/realtorProject/images/listImages/";
	
	@PostMapping("/addPicture")
	public String addPicture(@RequestParam("picture") MultipartFile[] files, RedirectAttributes ra, Model model,
	                         HttpSession session) {
		
		 Integer thisProductNo = (Integer) session.getAttribute("thisProductNo");
	    try {
	        File directory = new File(UPLOADED_PATH);
	        if (!directory.exists()) {
	        	// 경로가 없으면 생성
	        	directory.mkdirs(); 
	        }

	        // 업로드된 사진을 저장하는 로직
	        // 사진을 보낼 list 생성
	        List<String> photoList = new ArrayList<>();
	        
	        // 반복문으로 
	        for (MultipartFile file : files) {
	            String originalFileName = file.getOriginalFilename();
	            String newFileName = thisProductNo + "_" + originalFileName;
	            File dest = new File(UPLOADED_PATH + newFileName);
	            file.transferTo(dest);
	            
	            // 파일 이름 list를 사용하여 db에 저장하기
	            // array를 사용하지 않는 이유 : 연속적으로 표시하기 위해서
	            
	            // 
	            photoList.add(newFileName);
	            
	            
	            log.info("Uploaded file: " + newFileName);
	        }
	        
	        // 종료 후 db 에저장하기
	        service.listUpPhoto(thisProductNo, photoList);
	        

	        ra.addFlashAttribute("message", "사진이 성공적으로 업로드되었습니다.");
	    } catch (IOException e) {
	        ra.addFlashAttribute("message", "사진 업로드 중 오류가 발생했습니다.");
	        log.error("File upload error: " + e.getMessage());
	    }

	    return "redirect:/rMain/list";
	}

}
