package com.christy.spcd.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String hello(){
		return restTemplate.getForObject("http://spcd-order/order/order/test?client=admin", String.class);
	}
	
}
