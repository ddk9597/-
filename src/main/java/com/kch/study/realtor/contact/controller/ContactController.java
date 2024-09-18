package com.kch.study.realtor.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.contact.model.dto.ContactDTO;
import com.kch.study.realtor.contact.model.service.ContactService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/realtor/contact")
public class ContactController {

	private final ContactService service;
	
	@PostMapping("")
	public String contact(Model model, ContactDTO contactDTO, RedirectAttributes ra
			) {
		
		
		
		return "contact";
	}
	
}
