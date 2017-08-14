package com.christy.spcd.order.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.christy.spcd.core.mq.ConsumeTag;
import com.christy.spcd.core.mq.MQClient;
import com.christy.spcd.core.mq.MQSendResult;
import com.christy.spcd.order.tx.OrderPaidTransactionExecuter;
import com.christy.spcd.wsapi.order.OrderApi;
import com.christy.spcd.wsapi.order.message.OrderPaidSucceedMessage;

@RestController
public class OrderAPIController implements OrderApi{

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private MQClient mqClient;
	@Autowired
	private OrderPaidTransactionExecuter orderPaidTransactionExecuter;

	@Override
	public String orderTest(String client) {
		
		return "from order-"+applicationContext.getEnvironment().getProperty("server.port")+" : hello "+client;
	}

	@Override
	public String pay(Integer orderId) {
		MQSendResult result = mqClient.sendMessage(ConsumeTag.ORDER_PAID_SUCCEED, new OrderPaidSucceedMessage(orderId), String.valueOf(orderId));
		if(result == null){
			return "发送失败了";
		}
		return result.getMessageId();
	}
	
	@Override
	public String pay2(Integer orderId) {
		MQSendResult result = mqClient.sendTransactionMessage(ConsumeTag.ORDER_PAID_SUCCEED, new OrderPaidSucceedMessage(orderId), String.valueOf(orderId),orderPaidTransactionExecuter,orderId);
		if(result == null){
			return "发送失败了";
		}
		
		return result.getMessageId();
	}
	
}
