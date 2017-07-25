package com.christy.spcd.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christy.spcd.wsapi.order.OrderApi;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	@Autowired
	private OrderApi orderApi;
	@Value("${}")
	private String version;

	@RequestMapping("/hello")
	public String hello(){
		return orderApi.orderTest("mobile");
	}
	
	@RequestMapping("/version")
	public String version(){
		return orderApi.orderTest("mobile");
	}
}
