package com.christy.spcd.order.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.christy.spcd.wsapi.order.OrderApi;

@RestController
public class OrderAPIController implements OrderApi{
	
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public String orderTest(String client) {
		
		return "from order-"+applicationContext.getEnvironment().getProperty("server.port")+" : hello "+client;
	}

}
