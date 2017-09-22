package com.christy.spcd.core.mq;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.christy.spcd.core.SpringFactory;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

public class MQConsumerFactory {
	@Autowired
	private SpringFactory springFactory;
	
	private Properties properties;

	private List<ConsumeSpec> consumeSpecs;
	
	
	public MQConsumerFactory( Properties properties, List<ConsumeSpec> consumeSpecs){
		this.springFactory = springFactory;
		this.properties = properties;
		this.consumeSpecs = consumeSpecs;
	}
	@PostConstruct
	public void createConsumers(){
		if(CollectionUtils.isNotEmpty(consumeSpecs)){
			for (ConsumeSpec consumeSpec : consumeSpecs) {
				Consumer consumer = ONSFactory.createConsumer(properties);
				MessageListener messageListener = springFactory.getOrCreateBean(consumeSpec.getMessageListenerCls());
				consumer.subscribe(consumeSpec.getTag().getTopic(), consumeSpec.getTag().name(), messageListener);
				consumer.start();
			}
		}
	}

}
