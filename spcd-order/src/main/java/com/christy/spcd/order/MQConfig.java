package com.christy.spcd.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.christy.spcd.core.mq.ConsumeSpec;
import com.christy.spcd.core.mq.DefaultMQConfig;
import com.christy.spcd.core.mq.MQClient;
import com.christy.spcd.core.mq.MQClientBuilder;
import com.christy.spcd.core.mq.ProducerId;

@Configuration
public class MQConfig  extends DefaultMQConfig{
	
	@Bean
	public MQClient mqClient(){
		Properties properties = mqProperties();
		properties.put(PropertyKeyConst.ProducerId, producerId().name());
		return new MQClientBuilder(springFactory, properties).build();
	}

	@Override
	public List<ConsumeSpec> registerConsumeTags() {
		List<ConsumeSpec> consumeSpecs = new ArrayList<ConsumeSpec>();
		return consumeSpecs;
	}
	
	@Override
	protected ProducerId producerId() {
		return ProducerId.PID_ORDER_007;
	}

}
