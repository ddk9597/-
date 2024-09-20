package com.kch.study.realtor.contact.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

	private int contactNo;
	private String name;
	private String phone;
	private String prdKind;
	private String maxBudget;
	private String maxMonthPay; 
	private String minPy;
	private String maxPy;
	private String location;
	private String message; 
}
