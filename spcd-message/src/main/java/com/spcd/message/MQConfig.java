package com.spcd.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.christy.spcd.core.mq.ConsumeSpec;
import com.christy.spcd.core.mq.ConsumeTag;
import com.christy.spcd.core.mq.ConsumerId;
import com.christy.spcd.core.mq.DefaultMQConfig;
import com.christy.spcd.core.mq.MQConsumerFactory;
import com.spcd.message.common.listener.OrderPaidSucceedMessageListener;
@Configuration
public class MQConfig extends DefaultMQConfig{
	
	@Bean
	public MQConsumerFactory mqConsumerFactory (){
		Properties properties = mqProperties();
		properties.put(PropertyKeyConst.ConsumerId, consumerId().name());
		return new MQConsumerFactory(properties,registerConsumeTags());
	}

	@Override
	public List<ConsumeSpec> registerConsumeTags() {
		List<ConsumeSpec> consumeSpecs = new ArrayList<ConsumeSpec>();
		consumeSpecs.add(new ConsumeSpec(ConsumeTag.ORDER_PAID_SUCCEED, OrderPaidSucceedMessageListener.class));
		return consumeSpecs;
	}

	@Override
	protected ConsumerId consumerId() {
		return ConsumerId.CID_MESSAGE_007;
	}
	
}
