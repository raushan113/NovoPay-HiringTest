package com.novopay.hiringTest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.novopay.hiringTest.model.TransactionRecord;

public class MonthlyTransacation {

	public Map<Integer, Double> monthlyTransacationMap(List<TransactionRecord> transactionRecordList) {

		Map<Integer, Double> map = new HashMap<Integer, Double>();

		for (TransactionRecord transactionRecord : transactionRecordList) {

			if (map.isEmpty()) {
				map.put(transactionRecord.getMonth(), transactionRecord.getTransactionAmount());
			} else {
				int flag = 0;
				for (Map.Entry<Integer, Double> m : map.entrySet()) {
					if (m.getKey() == transactionRecord.getMonth()) {
						flag = 1;
						Integer key = m.getKey();
						Double monthlyTransactionAmount = transactionRecord.getTransactionAmount() + m.getValue();
						map.put(key, monthlyTransactionAmount);
						break;
					}
				}
				if (flag == 0) {
					map.put(transactionRecord.getMonth(), transactionRecord.getTransactionAmount());
				}
			}
		}

		return map;
	}

}
