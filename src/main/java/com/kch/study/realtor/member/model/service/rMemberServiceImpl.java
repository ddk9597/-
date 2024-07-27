package com.kch.study.realtor.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	// 비크립트 암호화
	private final BCryptPasswordEncoder bcrypt;

	// 메일 보내기
	private final JavaMailSender mailSender;
	private final SpringTemplateEngine templateEngine;

	// 회원가입하기
	@Override
	public int signUp(rMember inputMember) {

		// 비밀번호 bycrypt 암호화
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		return mapper.signUp(inputMember);
	}

	// 회원 가입 시 이메일 확인하기
	@Override
	public int checkEmail(String memberEmail) {
		return mapper.checkEmail(memberEmail);
	}

	// 인증메일 보내기
	@Override
	public String sendAuthKey(String memberEmail, String htmlName) {

		String authKey = createAuthKey();

		try {
			String subject = null;
			switch (htmlName) {
			case "signUp":
				subject = "강찬혁의 가짜 부동산 사이트 인증번호입니다.";
				break;
			}

			// 인증 메일 보내기

			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

			mimeHelper.setTo(memberEmail);
			mimeHelper.setSubject(subject);
			mimeHelper.setText(loadHtml(authKey, htmlName), true); // 타임리프가 적용된 html

			mailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		// 인증번호를 비교할 수 있도록 인증번호 전용 테이블에 전송한 인증번호를 저장
		Map<String, Object> map = new HashMap();
		map.put("memberEmail", memberEmail);
		map.put("authKey", authKey);

		// 1차 시도
		int result = mapper.updateAuthKey(map);

		// 2차 시도
		if (result == 0) {
			return mapper.insertAuthKey(map);
		}

		// 수정, 삭제 후에도 result가 0이면
		// 그만두고 null을 반환해라.
		if (result == 0) {
			return null;
		}

		// 오류없이 전송될 경우 authKey를 반환함
		return authKey;
	}

	public String loadHtml(String authKey, String htmlName) {

		// org.thymeleaf.context 선택!!!!!
		// forward하는 용도가 아닌 자바에서 쓰고싶을 때 쓰는 thymeleaf 객체
		Context context = new Context();

		// 타임리프가 적용된 html에서 사용할 값
		context.setVariable("authKey", authKey);

		// templates/email 폴더에서 htmlName과 같은 .html 파일 내용을 읽어와
		// String으로 변환을 시킨다
		return templateEngine.process("email/" + htmlName, context);

	}

	// 인증번호 생성
	public String createAuthKey() {

		String key = "";
		for (int i = 0; i < 5; i++) {

			int cel1 = (int) Math.random() * 3;

			if (cel1 == 0) {
				int num = (int) (Math.random() * 10);
				key += num;
			} else {
				// 영어알파벳 추가
				char ch = (char) (Math.random() * 26 + 65);
				int cel2 = (int) (Math.random() * 2);
				if (cel2 == 0) {
					ch = Character.toUpperCase(ch);
				}
				key += ch;

			}

		}

		return key;
	}

	// 입력한 인증메일이 보낸 인증메일과 동일한지 확인하기
	@Override
	public int checkAuthKey(Map<String, Object> map) {

		return mapper.checkAuthKey(map);
	}

}
