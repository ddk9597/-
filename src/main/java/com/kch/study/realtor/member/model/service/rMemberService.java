package com.kch.study.realtor.member.model.service;

import java.util.Map;

import com.kch.study.realtor.member.model.dto.rMember;

public interface rMemberService {
    int signUp(rMember inputMember);
    int checkEmail(String memberEmail);
    String sendAuthKey(String memberEmail, String htmlName);
    int checkAuthKey(Map<String, Object> map);
}


