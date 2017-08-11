package com.christy.spcd.core.mq;

import java.util.Properties;

import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.aliyun.openservices.ons.api.bean.TransactionProducerBean;
import com.aliyun.openservices.ons.api.transaction.LocalTransactionChecker;
import com.christy.spcd.core.SpringFactory;

public class MQClientBuilder {

	private SpringFactory springFactory;
	private Properties properties;
	public MQClientBuilder(SpringFactory springFactory,Properties properties) {
		this.springFactory = springFactory;
		this.properties = properties;
	}
	
	public MQClient build(){
		ProducerBean producerBean = new ProducerBean();
		TransactionProducerBean transactionProducerBean = new TransactionProducerBean();
		producerBean.setProperties(properties);
		transactionProducerBean.setProperties(properties);
		transactionProducerBean.setLocalTransactionChecker(localTransactionChecker());
		return new MQClient(producerBean, transactionProducerBean);
	}
	
	private LocalTransactionChecker localTransactionChecker(){
		LocalTransactionChecker checker = new DefaultTransactionChecker();
		springFactory.initializeBean(checker);
		return checker;
	}
	
}
