package com.kch.study.realtor.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class rMember {

	private int memberNo; 		// 회원 번호
	private int memberKind;		// 회원 종류 -> 신규임차인 :0, 임대인 : 1, 기존임차인 : 2, 중개업자 :3
	private String memberPw;	// 회원 비밀번호
	private String memberName;  // 회원 이름
	private String memberEmail; // 회원 이메일
	private String memberPhone; // 회원 전화번호
}
