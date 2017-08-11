package com.christy.spcd.order.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.openservices.ons.api.SendResult;
import com.christy.spcd.core.mq.ConsumeTag;
import com.christy.spcd.core.mq.MQClient;
import com.christy.spcd.wsapi.order.OrderApi;
import com.christy.spcd.wsapi.order.message.OrderPaidSucceedMessage;

@RestController
public class OrderAPIController implements OrderApi{
	
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private MQClient mqClient;

	@Override
	public String orderTest(String client) {
		
		return "from order-"+applicationContext.getEnvironment().getProperty("server.port")+" : hello "+client;
	}

	@Override
	public String pay(Integer orderId) {
		SendResult result = mqClient.sendMessage(ConsumeTag.ORDER_PAID_SUCCEED, new OrderPaidSucceedMessage(orderId), String.valueOf(orderId));
		if(result == null){
			return "发送失败了";
		}
		return result.getMessageId();
	}
	
}
