package com.kch.study.websocket.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.http.HttpSession;

/** 
 * WebSocketHandler가 동작하기 전, 후에 
 * 연결된 클라이언트의 세션을 가로채는 동작을 작성할 클래스
 */

@Component // bean 등록
public class SessionHandshakeInterceptor implements HandshakeInterceptor {

	// Handler 동작 전에 수행되는 메서드(전처리)
	@Override
	public boolean beforeHandshake(
			ServerHttpRequest request, 
			ServerHttpResponse response, 
			WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		// ServerHttpRequest request   : HttpServletRequest의 부모 인터페이스
		// ServerHttpResponse response : HttpServletResponse의 부모 인터페이스
		//		-> http 요청 기능들을 모두 적용하겠다(추상화)
		// attributes : 해당 맵에 세팅된 속성(데이터)은 다음에 동작할 Handler 객체에게 전달됨
		// HandShakeInterceptor -> Handler 데이터 전달하는 역할
		
		
		// request가 참조하는 객체가 ServletServerHttpRequest 로 다운캐스팅이 가능한 경우
		
		// ServerHttpRequest(부모, 현재 참조하는 객체), ServletServerHttpRequest(자식)
		//
		if(request instanceof ServletServerHttpRequest) { 
			
			// 다운캐스팅
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			
			// 웹소켓 동작을 요청한 클라이언트의 세션을 얻어옴
			HttpSession session = servletRequest.getServletRequest().getSession();
			
			// 가로챈 세션은 Handler에 전달할 수 있게 값 세팅
			attributes.put("session", session);
			
		}
		
		return true; // 가로채기 진행 여부 true로 작성해야 session 가로채서 handler에게 전달할 수 있음
	}

	// Handler동작 후에 수행되는 메서드
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
	}
	
}

