package com.kch.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// 스프링시큐리티 비활성화 -> 사이트 이용 자유롭게 가능함
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JustDoitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustDoitApplication.class, args);
	}

}
