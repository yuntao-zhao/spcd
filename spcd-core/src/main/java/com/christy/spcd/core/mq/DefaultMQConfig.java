package com.christy.spcd.core.mq;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.christy.spcd.core.SpringFactory;

public abstract class DefaultMQConfig implements ApplicationContextAware{
	
	protected SpringFactory springFactory;

	public Properties mqProperties(){
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.AccessKey, "在阿里云后台创建的AccessKey");
		properties.put(PropertyKeyConst.SecretKey, "在阿里云后台创建的AccessSecretKey");
		return properties;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.springFactory = applicationContext.getBean(SpringFactory.class);
	}

	public abstract List<ConsumeSpec> registerConsumeTags();

	protected ProducerId producerId() {
		return null;
	}
	
	protected ConsumerId consumerId(){
		return null;
	}
	
}
