package com.kch.study.realtor.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.member.model.service.rMemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("realtor/member")
@RequiredArgsConstructor
@Slf4j
public class rMemberController {

    private final rMemberService service;

    // 이메일 중복 검사
    @ResponseBody
    @GetMapping("checkEmail")
    public int checkEmail(@RequestParam("memberEmail") String memberEmail) {
        log.info("memberEmail : " + memberEmail);
        return service.checkEmail(memberEmail);
    }

    // 인증 메일 보내기
    @ResponseBody
    @PostMapping("sendAuthKey")
    public int sendAuthKey(@RequestBody Map<String, String> request) {
        String memberEmail = request.get("memberEmail");
        String htmlName = request.get("htmlName");

        String authKey = service.sendAuthKey(memberEmail, htmlName);
        
        if (authKey != null) {
            return 1;
        }
        // 인증메일 보내기 실패
        return 0;
    }
    
    @ResponseBody
    @PostMapping("checkAuthKey")
    public int checkAuthKey(@RequestBody Map<String, Object> map) {
        return service.checkAuthKey(map);
    }
    
    // 회원 가입
    @ResponseBody
    @PostMapping("signUp")
    public int signUp(@RequestBody rMember inputMember) {
        return service.signUp(inputMember);
    }
}




