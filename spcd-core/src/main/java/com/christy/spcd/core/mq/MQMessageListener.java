package com.christy.spcd.core.mq;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;

public abstract class MQMessageListener<T> implements MessageListener{

	@Override
	public Action consume(Message message, ConsumeContext consumecontext) {
		
		return null;
	}
	
	public abstract Action onMessage(T message);

}
