package com.example.springbootchatproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@SpringBootApplication
public class SpringBootChatProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootChatProjectApplication.class, args);
	}




}
