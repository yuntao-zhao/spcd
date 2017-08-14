package com.christy.spcd.core.mq;

import java.util.List;
import java.util.Properties;

import org.apache.commons.collections.CollectionUtils;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.christy.spcd.core.SpringFactory;

public class MQConsumerBuilder {
	
	private SpringFactory springFactory;
	
	private Properties properties;

	private List<ConsumeSpec> consumeSpecs;
	
	
	public MQConsumerBuilder(SpringFactory springFactory,Properties properties,List<ConsumeSpec> consumeSpecs){
		this.springFactory = springFactory;
		this.properties = properties;
		this.consumeSpecs = consumeSpecs;
	}
	
	public Consumer build(){
		if(CollectionUtils.isNotEmpty(consumeSpecs)){
			Consumer consumer = ONSFactory.createConsumer(properties);
			for (ConsumeSpec consumeSpec : consumeSpecs) {
				MessageListener messageListener = springFactory.getOrCreateBean(consumeSpec.getMessageListenerCls());
				consumer.subscribe(consumeSpec.getTag().getTopic(), consumeSpec.getTag().name(), messageListener);
			}
			consumer.start();
			return consumer;
		}
		return null;
	}

}
