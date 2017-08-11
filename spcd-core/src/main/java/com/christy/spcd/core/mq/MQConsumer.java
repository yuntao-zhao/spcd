package com.christy.spcd.core.mq;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.aliyun.openservices.ons.api.bean.ConsumerBean;

public class MQConsumer extends ConsumerBean implements InitializingBean,DisposableBean{

	@Override
	public void destroy() throws Exception {
		super.shutdown();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.start();
	}

}
