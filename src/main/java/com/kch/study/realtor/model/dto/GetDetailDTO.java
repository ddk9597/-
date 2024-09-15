package com.kch.study.realtor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GetDetailDTO {

	// 매물 번호
	private int propertiesNo;
	// 회원 번호
	private int memberNo;
	
	// 매물정보
	// 매물 주소 
	private String locationTitle;
	// 매물 종류
	private String category;
	// 층
	private String floor;
	// 권리금 유무 여부
	private String premium;
	// 보증금
	private String deposit;
	private String rent;
	private String adminCost;
	
	// 매물 상세 정보
	private String noteForCustomer;
	
	
	
	
}
