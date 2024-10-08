package com.kch.study.websocket.handler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestWebSocketHandler extends TextWebSocketHandler{

	
	// webSocketSession : 웹소켓 전용 세션
		// - 클라이언트 - 서버 간 전이중 통신을 담당하는 객체
		// - SessionHandshakeInterceptor가 가로챈 연결한 클라이언트의 HttpSesison을 가지고 있음
		//   (attributes에 추가한 값)
		
		// 동기화된 Set 생성
		// (동기화 장점 : 충돌 발생 x, 단점 : 느림)
		private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
		
		

		// 클라이언트와 연결이 완료되고, 통신할 준비가 완료됨
		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			
			// 연결된 클라이언트의 WebSocketSession 정보를 set에 추가
			// -> 웹소켓에 연결된 클라이언트 정보를 모아둠
			sessions.add(session);
			
			
		}
		
		 // 클라이언트와 연결이 종료되면 실행
		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			
			// 웹 소켓 연결이 끊긴 클라이언트 정보를 Set에서 제거
			sessions.remove(session);
			
		}

		@Override
		protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

			// TextMessage : 웹소켓으로 연결된 클라이언트가 전달한 텍스트(내용)이 담겨있는 객체
			// Payload : 통신 시 탐재된 데이터
			log.info("전달받은 메세지 : {}", message.getPayload());
			
			// 전달 받은 메세지를 현재 해당 웹소켓에 연결된 모든 클라이언트에게 보내기
			for(WebSocketSession s : sessions) {
				s.sendMessage(message);
			}
			
		}
}
