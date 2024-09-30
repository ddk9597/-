package com.kch.study.websocket.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.kch.study.websocket.handler.ChattingWebsocketHandler;
import com.kch.study.websocket.handler.NotificationWebsocketHandler;
import com.kch.study.websocket.handler.TestWebSocketHandler;

import lombok.RequiredArgsConstructor;


@Configuration // 서버 실행 시 작성된 메서드를 모두 수행
@EnableWebSocket // 웹소켓 활성화 설정
@RequiredArgsConstructor
public class WebsocketConfig implements WebSocketConfigurer {

	// 웹소켓 처리 동작이 작성된 객체 의존성 주입(DI)
	private final TestWebSocketHandler testWebsocketHandler;

	// bean으로 등록된 sessionHandshakeInterceptor 가 의존성 주입된다
	private final HandshakeInterceptor handshakeInterceptor;

	// 알림 웹소켓 처리 객체 의존성 주입
	private final NotificationWebsocketHandler notificationWebsocketHandler;
	
	// 채팅과 관련된 웹소켓 객체를 의존성 주입
	private final ChattingWebsocketHandler chattingWebsocketHandler;

	// 웹소켓 핸들러를 등록하는 메서드
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		// addHandler(웹소켓 핸들러, 웹소켓 요청 주소)
		
		
		registry.addHandler(testWebsocketHandler, "/testSock")
		// -> websocket://localhost/testSock 으로 클라이언트가 요청을 하면 
		//    testWebsocketHandler가 처리하도록 등록
		// /testSock 경로에서 WebSocket 연결을 처리하는 핸들러인 testWebsocketHandler를 등록하는 코드
		// testWebSockeyHandelr : webSockey 연결 시 들어오는 메세지를 처리하는 역할을 함.
		// 웹소켓 핸들러는 클라이언트와의 통신을 처리하며, 메세지를 수신하거나 응답을 보내는 로직 구현 가능
		
		// 경로 : /testSock 경로로 클라이언트가 webSocket 연결을 요청하면 이 핸들러가 연결 요청을 처리함.
		
		.addInterceptors(handshakeInterceptor)
		// -> 클라이언트 연결 시 HttpSession을 가로채 핸들러에 전달
		// handShakeInterceptor를 웹소켓 연결 과정에서 추가하는 코드
		// hadShakeInterceptor는 웹소켓 연결 과정에서 초기 httpHandshake가 이루어질 때, http세션이나
		// 사용자 정보를 처리하기 위해 사용됨. 예를 들어 사용자의 세션 정보를 핸들러에 전달하거나 연결 전에
		// 인증을 수행할 수 있음.
		// 즉 웹 소켓 연결 시 클라이언트의 요청을 가로채고 http 세션 정보나 
		// 사용자 인증 정보를 검증한 뒤 핸들러로 넘겨줌
		
		
		.setAllowedOriginPatterns("http://localhost/",
								  "http://127.0.0.1/",
								  "http://192.168.10.17")
		// -> 웹소켓 요청이 허용되는 ip/도메인 지정하는 부분
		// 이 목록에 없는 도메인에서 요청하면 서버는 연결 거부 가능함
		.withSockJS(); 
		// SockJs(websocket 보완) 지원 + 브라우저 호환성 증가
		// sockJs : 웹소켓을 지원하지 않는 브라우저에서도 webSocket을 사용할 수 있도록 해주는 라이브러리
		// webSocket에 지원되지 않을 경우 sockjs는 자동으로 다른 전송 메커니즘(http폴링, long폴링 등) 을 사용하여
		// webSocket과 유사한 기능을 제공하며 
		// 다양한 브라우저에서 webSocket 기능을 사용 할 수 있게함 (브라우저 호환성 증가
		
		
		// 알림 처리 핸들러와 주소 연결 
		registry.addHandler(notificationWebsocketHandler, "/notification/send")
		// noticficationWebsocketHandelr 를 위 경로에 등록하여
		// 클라이언트가 해당 경로로 webSocket 연결을 요청하면, notificationWebsocketHandler가 그 요청을 처리함
		// notificationWebsocketHandelr는 서버에서 클라이언트로 알림을 실시간으로 전송하거나 클라이언트가 보낸 메세지를
		// 처리하는 역할을 함
				.addInterceptors(handshakeInterceptor)
				.setAllowedOriginPatterns("http://localhost/",
										  "http://127.0.0.1/",
										  "http://192.168.10.17")
				// -> 웹소켓 요청이 허용되는 ip/도메인 지정하는 부분
				
				.withSockJS(); 
				// SockJs(websocket 보완) 지원 + 브라우저 호환성 증가
				
		
		// 채팅 처리 핸들러와 주소 연결 
			registry.addHandler(chattingWebsocketHandler, "/chattingSock")
					.addInterceptors(handshakeInterceptor)
					.setAllowedOriginPatterns("http://localhost/",
											  "http://127.0.0.1/",
											  "http://192.168.10.17")
					.withSockJS(); 
		
	}

}
