package com.christy.spcd.wsapi.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
//@FEI
public interface OrderApi {

	@RequestMapping("/order/test")
	String orderTest(String client);
}
