package com.christy.spcd.core.mq;

import java.nio.charset.Charset;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.transaction.LocalTransactionExecuter;
import com.aliyun.openservices.ons.api.transaction.TransactionProducer;

public class MQClient implements InitializingBean,DisposableBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MQClient.class);
	
	private Producer producer;
	
	private TransactionProducer transactionProducer;
	
	public MQClient(Producer producer,TransactionProducer transactionProducer) {
		this.producer = producer;
		this.transactionProducer = transactionProducer;
	}
	
	public MQSendResult sendMessage(ConsumeTag tag,Object body,String key){
		try{
			Message message = wrapMessage(tag, body, key);
			MQSendResult result =  MQSendResult.convert(producer.send(message));
			LOGGER.info("MQ send result  {}",JSON.toJSON(result));
			return result;
		}catch (Exception e){
			LOGGER.error(e.getMessage(),e);
		}
		return null;
	}
	
	public MQSendResult sendTransactionMessage(ConsumeTag tag,Object body,String key,LocalTransactionExecuter executer,Object arg){
		try{
			Message message = wrapMessage(tag, body, key);
			MQSendResult result = MQSendResult.convert(transactionProducer.send(message, executer, arg));
			LOGGER.info("MQ send result  {}",JSON.toJSON(result));
			return result;
		}catch (Exception e){
			LOGGER.error(e.getMessage(),e);
		}
		return null;
	}
	
	private Message wrapMessage(ConsumeTag tag,Object body,String key){
		byte[] byteBody = null;
		String topic = tag.getTopic();
		if(body.getClass().isPrimitive() || body.getClass() == String.class) {
			byteBody = String.valueOf(body).getBytes(Charset.forName("UTF-8"));
		} else {
			byteBody = JSON.toJSONBytes(body);
		}
		key = topic + "_" + tag.name() + "_" + key;
		Message message = new Message(topic,tag.name(),key,byteBody);
		message.putUserProperties("messageType", body.getClass().getName());
		message.putUserProperties("_uuid", System.nanoTime() + UUID.randomUUID().toString().replaceAll("-", ""));
		return message;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {

		if(producer != null){
			producer.start();
		}
		
		if(transactionProducer != null){
			transactionProducer.start();
		}
	}
	
	@Override
	public void destroy() throws Exception {
		if(producer != null){
			producer.shutdown();
		}
		
		if(transactionProducer != null){
			transactionProducer.shutdown();
		}
	}

	
}
