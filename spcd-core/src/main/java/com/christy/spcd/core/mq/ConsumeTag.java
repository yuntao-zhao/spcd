package com.christy.spcd.core.mq;

public enum ConsumeTag {
	ORDER_PAID_SUCCEED("ORDER1"),
	USER_REGISTERED("USER"), 
	;
	
	private String topic;
	ConsumeTag(String topic) {
		this.topic = topic;
	}
	
	public String getTopic() {
		return topic;
	}
}
