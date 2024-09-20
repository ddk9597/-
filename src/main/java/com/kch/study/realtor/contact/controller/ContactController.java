package com.kch.study.realtor.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.contact.model.dto.ContactDTO;
import com.kch.study.realtor.contact.model.service.ContactService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/realtor/contact")
public class ContactController {

	private final ContactService service;

	@PostMapping("/makeContactRequest")
	public String contact(Model model, @ModelAttribute ContactDTO contactDTO, RedirectAttributes ra) {
		
		int result = service.saveContactRequest(contactDTO); 
		String message = null;
		
		if(result == 1) {
			
			message = "요청이 성공적으로 등록 되었습니다.";
		} else {
			message = "요청 등록 실패.. 관리자에게 문의하세요";
		}

		model.addAttribute("message", message);
		
		return "redirect:/contact"; 
	}

}
