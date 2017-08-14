package com.christy.spcd.core.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;

public abstract class MQMessageListener<T> implements MessageListener{
	private static final Logger LOGGER = LoggerFactory.getLogger(MQMessageListener.class);

	@SuppressWarnings("unchecked")
	@Override
	public Action consume(Message message, ConsumeContext consumecontext) {
		T messageBody = null;
		Class<?> messageType;
		try {
			messageType = Class.forName(message.getUserProperties("messageType"));
			if(messageType.isPrimitive() || messageType == String.class) {
				messageBody = (T)new String(message.getBody());
			} else {
				messageBody = JSON.parseObject(message.getBody(), messageType);
			}
			return onMessage(messageBody);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			return Action.ReconsumeLater;
		}
	}
	
	public abstract Action onMessage(T message);

}
