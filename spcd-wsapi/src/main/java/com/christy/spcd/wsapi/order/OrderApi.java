package com.christy.spcd.wsapi.order;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@FeignClient("spcd-order")
public interface OrderApi {

	@RequestMapping("/order/test")
	String orderTest(@RequestParam("client")String client);
}
