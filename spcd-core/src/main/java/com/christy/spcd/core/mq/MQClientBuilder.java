package com.christy.spcd.core.mq;

import java.util.Properties;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.transaction.LocalTransactionChecker;
import com.aliyun.openservices.ons.api.transaction.TransactionProducer;
import com.christy.spcd.core.SpringFactory;

public class MQClientBuilder {

	private SpringFactory springFactory;
	private Properties properties;
	public MQClientBuilder(SpringFactory springFactory,Properties properties) {
		this.springFactory = springFactory;
		this.properties = properties;
	}
	
	public MQClient build(){
		Producer producer =ONSFactory.createProducer(properties);
		TransactionProducer transactionProducer = ONSFactory.createTransactionProducer(properties,localTransactionChecker());
		return new MQClient(producer, transactionProducer);
	}
	
	private LocalTransactionChecker localTransactionChecker(){
		DefaultTransactionChecker checker = new DefaultTransactionChecker();
		springFactory.initializeBean(checker);
		return checker;
	}
	
}
