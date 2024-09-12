package com.kch.study.realtor.list.model.dto;

import java.util.List;

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
	private Integer propertiesNo;
	private Integer memberNo;
	private Integer areaCode;
	private String locationTitle;
	private String addressNo;
	private String category;
	private Integer isTenant; // 공실여부 - 0:공실, 1:공실아님
	private String shopName;
	private String contactInfo;
	private String floor;
	private String py;
	private Integer premium;
	private Integer deposit;
	private Integer rent;
	private Integer adminCost;
	private String note;
	private String photo;
	private List<String> imageList;
	
	
}
