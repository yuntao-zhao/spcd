package com.christy.spcd.wsapi.order;

import org.springframework.stereotype.Component;

@Component
public class OrderAPIHystrix implements OrderApi{

	@Override
	public String orderTest(String client) {
		return "出错了啊啊啊啊";
	}

	@Override
	public String pay(Integer orderId) {
		return "支付失败，请稍后再试";
	}

}
