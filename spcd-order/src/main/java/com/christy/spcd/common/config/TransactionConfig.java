package com.christy.spcd.common.config;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionConfig {

	private static ConcurrentHashMap<Integer, Boolean> transactionMap = new ConcurrentHashMap<Integer, Boolean>();
	
	public static void put(Integer orderId,Boolean isComplated){
		transactionMap.put(orderId, isComplated);
	}
	
	public static boolean isComplated(Integer orderId){
		return transactionMap.getOrDefault(orderId, false);
	}
}
