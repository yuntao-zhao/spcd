package com.christy.spcd.wsapi.order;

import org.springframework.web.bind.annotation.RequestMapping;

public interface OrderApi {

	@RequestMapping("/order/test")
	String orderTest(String client);
}
