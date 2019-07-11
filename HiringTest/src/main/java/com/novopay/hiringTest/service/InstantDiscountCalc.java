package com.novopay.hiringTest.service;

import java.util.List;

import com.novopay.hiringTest.model.InstantSlab;
import com.novopay.hiringTest.model.TransactionRecord;

public class InstantDiscountCalc {

	public double instantDiscountCalculator(TransactionRecord transactionRecord) {

		List<InstantSlab> instantSlabList = InstantAndMonthlySlabGenerate.instantSlabList;
		double instantDiscount = 0.0d;
		for (InstantSlab instantSlabValue : instantSlabList) {

			if (transactionRecord.getTransactionAmount() <= instantSlabValue.getLimitamount()) {
				instantDiscount = (transactionRecord.getTransactionAmount() * instantSlabValue.getDiscount()) / 100;

				break;
			} else {
				instantDiscount = (transactionRecord.getTransactionAmount() * instantSlabValue.getDiscount()) / 100;

			}
		}
		return instantDiscount;
	}

}
