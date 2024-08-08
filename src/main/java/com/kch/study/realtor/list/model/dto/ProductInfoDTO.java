package com.kch.study.realtor.list.model.dto;

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
public class ProductInfoDTO {
	private int productNo;
	private int memberNo;
	private String locationTitle;
	private int areaCode;
	private String address;
	private String shopName;
	private int category;
	private String contactInfo;
	private String floor;
	private String py;
	private int premium;
	private int deposit;
	private int rent;
	private int adminCost;
	private String note;
	private int isTenant; // 공실여부 - 0:공실, 1:공실아님
	
	
}
