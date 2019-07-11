package com.novopay.hiringTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.novopay.hiringTest.model.TransactionRecord;
import com.novopay.hiringTest.service.InstantAndMonthlySlabGenerate;
import com.novopay.hiringTest.service.InstantDiscountCalc;
import com.novopay.hiringTest.service.MonthlyDiscountCalc;
import com.novopay.hiringTest.service.MonthlyTransacation;
import com.novopay.hiringTest.service.TotalInstantDiscountPerMonth;
import com.novopay.hiringTest.service.TranscationRecordGenerate;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("src/main/resources/slabs.txt");

		Scanner sc = new Scanner(file);

		InstantAndMonthlySlabGenerate instantAndMonthlySlabGenerate = new InstantAndMonthlySlabGenerate();
		instantAndMonthlySlabGenerate.InstantAndMonthlySlabGenerator(sc);

		File testFile = new File("src/main/resources/testFile.txt");

		Scanner sc1 = new Scanner(testFile);
		TranscationRecordGenerate transcationRecordGenerate = new TranscationRecordGenerate();
		List<TransactionRecord> transactionRecordList = transcationRecordGenerate.TranscationRecordGenerator(sc1);

		InstantDiscountCalc instantDiscountCalc = new InstantDiscountCalc();
		for (TransactionRecord transactionRecord : transactionRecordList) {
			double instantDiscount = instantDiscountCalc.instantDiscountCalculator(transactionRecord);

			transactionRecord.setInstantDiscount(instantDiscount);

		}
		TotalInstantDiscountPerMonth totalInstantDiscountPerMonth = new TotalInstantDiscountPerMonth();
		Map<Integer, Double> instantDiscountMonthlyMap = totalInstantDiscountPerMonth
				.totalInstantDiscountPerMonthCalc(transactionRecordList);

		MonthlyTransacation monthlyTransacation = new MonthlyTransacation();
		Map<Integer, Double> monthlyTransacationMap = monthlyTransacation.monthlyTransacationMap(transactionRecordList);

		MonthlyDiscountCalc monthlyDiscountCalc = new MonthlyDiscountCalc();
		Map<Integer, Double> monthlyDiscountMap = monthlyDiscountCalc.monthlyDiscountCalculator(monthlyTransacationMap);

		Map<Integer, Double> sortedInstantMonthlyDiscountMap = new TreeMap<Integer, Double>(instantDiscountMonthlyMap);
		Map<Integer, Double> sortedMonthlyDiscountMap = new TreeMap<Integer, Double>(monthlyDiscountMap);

		for (Map.Entry<Integer, Double> entry : sortedInstantMonthlyDiscountMap.entrySet()) {
			Integer key = entry.getKey();
			Double monthlyInstantDiscount = entry.getValue();
			Double monthlyDiscount = sortedMonthlyDiscountMap.get(key);
			Double monthlyTransaction = monthlyTransacationMap.get(key);

			Double bill = monthlyTransaction - (monthlyInstantDiscount + monthlyDiscount);
			System.out.println("Month = " + key + ",Total Bill = " + bill);
		}

	}

}
