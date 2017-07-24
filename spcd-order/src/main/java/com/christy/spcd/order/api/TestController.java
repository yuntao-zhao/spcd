package com.christy.spcd.order.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/001")
	public String test(){
		
		return "SUCCESS";
	}
	
}
