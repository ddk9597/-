package com.kch.study.realtor.contact.model.service;

import org.springframework.stereotype.Service;

import com.kch.study.realtor.contact.model.mapper.ContactMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactImpl implements ContactService {

	private final ContactMapper mapper;
	
	
}
