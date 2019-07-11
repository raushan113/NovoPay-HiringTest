package com.novopay.hiringTest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.novopay.hiringTest.model.MonthlySlab;

public class MonthlyDiscountCalc {

	public Map<Integer, Double> monthlyDiscountCalculator(Map<Integer, Double> monthlyTransacationMap) {
		Map<Integer, Double> monthlyDiscountMap = new HashMap<Integer, Double>();
		List<MonthlySlab> monthlySlabList = InstantAndMonthlySlabGenerate.monthlySlabList;
		double monthlyDiscount = 0.0d;

		for (Map.Entry<Integer, Double> map : monthlyTransacationMap.entrySet()) {
			for (MonthlySlab monthlySlabValue : monthlySlabList) {

				if (map.getValue() <= monthlySlabValue.getLimitamount()) {
					monthlyDiscount = (map.getValue() * monthlySlabValue.getDiscount()) / 100;
					monthlyDiscountMap.put(map.getKey(), monthlyDiscount);
					break;
				} else {
					monthlyDiscount = (map.getValue() * monthlySlabValue.getDiscount()) / 100;
					monthlyDiscountMap.put(map.getKey(), monthlyDiscount);
				}
			}
		}

		return monthlyDiscountMap;
	}

}
