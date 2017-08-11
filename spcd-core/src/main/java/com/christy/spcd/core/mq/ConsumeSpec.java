package com.christy.spcd.core.mq;

import com.aliyun.openservices.ons.api.MessageListener;

public class ConsumeSpec {

	private ConsumeTag tag;
	
	private Class<? extends MessageListener> messageListenerCls; 
	
	public ConsumeSpec() {

	}

	public ConsumeSpec(ConsumeTag tag, Class<? extends MessageListener> messageListenerCls) {
		this.tag = tag;
		this.messageListenerCls = messageListenerCls;
	}

	public ConsumeTag getTag() {
		return tag;
	}

	public void setTag(ConsumeTag tag) {
		this.tag = tag;
	}

	public Class<? extends MessageListener> getMessageListenerCls() {
		return messageListenerCls;
	}
	
	public void setMessageListenerCls(Class<? extends MessageListener> messageListenerCls) {
		this.messageListenerCls = messageListenerCls;
	}
}
