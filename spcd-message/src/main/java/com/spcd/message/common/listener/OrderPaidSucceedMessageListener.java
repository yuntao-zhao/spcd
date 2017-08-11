package com.spcd.message.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.openservices.ons.api.Action;
import com.christy.spcd.core.mq.MQMessageListener;
import com.christy.spcd.wsapi.order.message.OrderPaidSucceedMessage;

public class OrderPaidSucceedMessageListener extends MQMessageListener<OrderPaidSucceedMessage>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderPaidSucceedMessageListener.class);

	@Override
	public Action onMessage(OrderPaidSucceedMessage message) {
		LOGGER.info("received message is {}",message.getOrderId());
		return Action.CommitMessage;
	}

}
