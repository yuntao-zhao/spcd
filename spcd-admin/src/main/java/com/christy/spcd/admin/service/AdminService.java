package com.christy.spcd.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AdminService {

	@Autowired
	private RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod="hellCallBack")
	public String hello(){
		return restTemplate.getForObject("http://spcd-order/order/test?client=admin", String.class);
	}
	
	public String hellCallBack(){
		return "出错啦";
	}
}
