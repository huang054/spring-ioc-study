package com.example.springMvc.controller;

import com.example.springMvc.Event.CustomizePublisher;
import com.example.springMvc.beanRigest.Beans;
import com.example.springMvc.beanRigest.BeansTest;
import com.example.springMvc.beanRigest.CalculateService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService service;
	@Autowired
	private BeansTest bean;

	@Autowired
	CalculateService calculateService1;

	@Autowired
	private CustomizePublisher customizePublisher;

	@RequestMapping("/publish")
	public String publish(){

		customizePublisher.publishEvent();

		return "publish finish, "
				+ new Date();
	}

	@RequestMapping("/hello")
	@AnnTest
	public String test( HttpServletResponse response) {
        System.out.println("calss:"+bean);
		System.out.println("calss1:"+calculateService1);
		System.out.println("String:"+calculateService1.getServiceDesc());
		Cookie cookie = new Cookie("ssoToken", "123456789");
		cookie.setPath("/");
		response.addCookie(cookie);
		System.out.println("hello");
		return "hello";
	}

	@RequestMapping("/hello1")
	@AnnTest
	public String test1(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		boolean b =false;
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("ssoToken")&&cookie.getValue().equals("123456789")){
					System.out.println("登录成功");
					b=true;
					break;
				}
			}
		}
		if(b) {
			return service.hello();
		}else{
			return "没有登录";
		}
	}

}
