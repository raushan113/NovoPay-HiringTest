package com.novopay.hiringTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.novopay.hiringTest.model.TransactionRecord;

public class TranscationRecordGenerate {

	public List<TransactionRecord> TranscationRecordGenerator(Scanner sc) {

		List<TransactionRecord> transactionRecordList = new ArrayList<TransactionRecord>();

		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			String str[] = input.split(" ");
			String sr[] = str[0].split("/");
			Double amount = Double.parseDouble(str[1]);
			Integer date = Integer.parseInt(sr[0]);
			Integer month = Integer.parseInt(sr[1]);
			Integer year = Integer.parseInt(sr[2]);
			TransactionRecord transactionRecord = new TransactionRecord(date, month, year, amount);
			transactionRecordList.add(transactionRecord);
		}

		return transactionRecordList;
	}
}
