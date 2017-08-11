package com.christy.spcd.core.mq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.transaction.LocalTransactionChecker;
import com.aliyun.openservices.ons.api.transaction.TransactionStatus;

public class DefaultTransactionChecker implements LocalTransactionChecker{
	
	@Autowired(required=false)
	private List<TransactionCheckStrategy<?>> strategies;

	@Override
	public TransactionStatus check(Message message) {
		for (TransactionCheckStrategy<?> strategy : strategies) {
			if(strategy.support(ConsumeTag.valueOf(message.getTag()))){
				return strategy.check(message);
			}
		}
		return TransactionStatus.Unknow;
	}

}
