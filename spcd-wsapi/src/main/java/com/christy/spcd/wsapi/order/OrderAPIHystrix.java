package com.christy.spcd.wsapi.order;

import org.springframework.stereotype.Component;

@Component
public class OrderAPIHystrix implements OrderApi{

	@Override
	public String orderTest(String client) {
		return "出错了啊啊啊啊";
	}

}
