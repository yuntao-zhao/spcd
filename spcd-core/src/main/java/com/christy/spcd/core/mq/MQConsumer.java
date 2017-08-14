package com.christy.spcd.core.mq;

import org.springframework.beans.factory.DisposableBean;

import com.aliyun.openservices.ons.api.bean.ConsumerBean;

public class MQConsumer extends ConsumerBean implements DisposableBean{

	@Override
	public void destroy() throws Exception {
		super.shutdown();
	}

}
