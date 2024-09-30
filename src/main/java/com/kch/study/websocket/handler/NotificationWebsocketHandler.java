package com.kch.study.websocket.handler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kch.study.websocket.model.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("notification")
@RequiredArgsConstructor
public class NotificationWebsocketHandler extends TextWebSocketHandler{
	
	private final NotificationService notificationService;
	
	// websocketSession : 클라이언트와 서버의 전이중 통신 담당 객체
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
	}
	
}
