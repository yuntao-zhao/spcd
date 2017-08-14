package com.christy.spcd.order.tx;

import org.springframework.stereotype.Service;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.transaction.TransactionStatus;
import com.christy.spcd.common.config.TransactionConfig;
import com.christy.spcd.core.mq.ConsumeTag;
import com.christy.spcd.core.mq.TransactionCheckStrategy;
import com.christy.spcd.wsapi.order.message.OrderPaidSucceedMessage;
@Service
public class OrderPaidTransactionExecuter extends TransactionCheckStrategy<OrderPaidSucceedMessage>{

	@Override
	public TransactionStatus execute(Message message, Object arg) {
		Integer orderId = (Integer) arg;
		TransactionConfig.put(orderId, true);
		return TransactionStatus.CommitTransaction;
	}

	@Override
	public boolean support(ConsumeTag tag) {
		return ConsumeTag.ORDER_PAID_SUCCEED == tag;
	}

	@Override
	public TransactionStatus checkLocalTransaction(OrderPaidSucceedMessage message) {
		if(TransactionConfig.isComplated(message.getOrderId())){
			return TransactionStatus.CommitTransaction;
		}
		return TransactionStatus.RollbackTransaction;
	}

}
