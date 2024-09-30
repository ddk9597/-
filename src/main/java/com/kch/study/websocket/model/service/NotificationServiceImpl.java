package com.kch.study.websocket.model.service;

import org.springframework.stereotype.Service;

import com.kch.study.websocket.model.mapper.NotificationMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{

	private final NotificationMapper mapper;
	
}
