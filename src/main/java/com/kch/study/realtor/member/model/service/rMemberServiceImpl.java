package com.kch.study.realtor.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.kch.study.realtor.member.model.dto.rMember;
import com.kch.study.realtor.member.model.mapper.rMemberMapper;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class rMemberServiceImpl implements rMemberService {

    private final rMemberMapper mapper;
    private final BCryptPasswordEncoder bcrypt;
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Override
    public int signUp(rMember inputMember) {
        String encPw = bcrypt.encode(inputMember.getMemberPw());
        inputMember.setMemberPw(encPw);
        return mapper.signUp(inputMember);
    }

    @Override
    public int checkEmail(String memberEmail) {
        return mapper.checkEmail(memberEmail);
    }

    @Override
    public String sendAuthKey(String memberEmail, String htmlName) {
        String authKey = createAuthKey();

        try {
            String subject = "인증번호입니다.";

            if ("signUp".equals(htmlName)) {
                subject = "강찬혁의 가짜 부동산 사이트 인증번호입니다.";
            }

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            mimeHelper.setTo(memberEmail);
            mimeHelper.setSubject(subject);
            mimeHelper.setText(loadHtml(authKey, htmlName), true);

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("memberEmail", memberEmail);
        map.put("authKey", authKey);

        int result = mapper.updateAuthKey(map);

        if (result == 0) {
            result = mapper.insertAuthKey(map);
        }

        return result == 0 ? null : authKey;
    }

    private String loadHtml(String authKey, String htmlName) {
        Context context = new Context();
        context.setVariable("authKey", authKey);
        return templateEngine.process("email/" + htmlName, context);
    }

    private String createAuthKey() {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int cel1 = (int) (Math.random() * 3);
            if (cel1 == 0) {
                int num = (int) (Math.random() * 10);
                key.append(num);
            } else {
                char ch = (char) (Math.random() * 26 + 65);
                if ((int) (Math.random() * 2) == 0) {
                    ch = Character.toUpperCase(ch);
                }
                key.append(ch);
            }
        }
        return key.toString();
    }

    @Override
    public int checkAuthKey(Map<String, Object> map) {
        return mapper.checkAuthKey(map);
    }
    
    // 로그인시 입력한 이메일로 가입된 아이디 있는지 확인
    @Override
    public int checkLoginEmail(String email) {
    	return mapper.checkLoginEmail(email);
    }
    
    // 로그인 비밀번호 확인
    // map : memberEmail, inputPw
    @Override
    public boolean checkLoginPw(Map<String, Object> map) {
        String email = (String) map.get("memberEmail");
        String inputPw = (String) map.get("inputPw");

        // 데이터베이스에서 이메일에 해당하는 저장된 비밀번호 가져오기
        String storedPw = mapper.getStoredPassword(email);
        
        if (storedPw != null && BCrypt.checkpw(inputPw, storedPw)) {
            return true; // 비밀번호 일치
        } else {
            return false; // 비밀번호 불일치
        }
    }
    
    // 로그인한 회원 번호 가져오기
    @Override
    public int getMemberNo(String email) {
    	return mapper.getMemberNo(email);
    }
}





