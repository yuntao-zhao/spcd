package com.christy.spcd.core.mq;

import java.util.List;
import java.util.Properties;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;

import com.aliyun.openservices.ons.api.MessageListener;
import com.christy.spcd.core.SpringFactory;

public class MQConsumerFactory implements InitializingBean{
	
	private SpringFactory springFactory;
	
	private Properties properties;

	private List<ConsumeSpec> consumeSpecs;
	
	
	public MQConsumerFactory(SpringFactory springFactory,Properties properties,List<ConsumeSpec> consumeSpecs){
		this.springFactory = springFactory;
		this.properties = properties;
		this.consumeSpecs = consumeSpecs;
	}
	
	public void createConsumer(){
		if(CollectionUtils.isNotEmpty(consumeSpecs)){
			for (ConsumeSpec consumeSpec : consumeSpecs) {
				MQConsumer consumerBean = new MQConsumer();
				consumerBean.setProperties(properties);
				MessageListener messageListener = springFactory.getOrCreateBean(consumeSpec.getMessageListenerCls());
				consumerBean.subscribe(consumeSpec.getTag().getTopic(), consumeSpec.getTag().name(), messageListener);
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		createConsumer();
	} 
}
