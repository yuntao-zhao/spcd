package com.christy.spcd.wsapi.order;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="spcd-order",fallback=OrderAPIHystrix.class)
public interface OrderApi {

	@RequestMapping("/order/test")
	String orderTest(@RequestParam("client")String client);
	@RequestMapping("/order/pay")
	String pay(@RequestParam("orderId")Integer orderId);
	@RequestMapping("/order/pay2")
	String pay2(@RequestParam("orderId")Integer orderId);
}
