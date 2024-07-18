package com.kch.study.hobbyGroup.common.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kch.study.hobbyGroup.common.model.service.hgService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("hg")
@RequiredArgsConstructor
public class hgMainController {

	private final hgService service;
	
}
