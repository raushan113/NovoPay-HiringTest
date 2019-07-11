package com.novopay.hiringTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.novopay.hiringTest.model.InstantSlab;
import com.novopay.hiringTest.model.MonthlySlab;

public class InstantAndMonthlySlabGenerate {

	static List<InstantSlab> instantSlabList = new ArrayList<InstantSlab>();
	static List<MonthlySlab> monthlySlabList = new ArrayList<MonthlySlab>();

	public List<Object> InstantAndMonthlySlabGenerator(Scanner sc) {
		int flag = 0;

		while (sc.hasNextLine()) {
			String inputLine = sc.nextLine();

			if (inputLine.equalsIgnoreCase("instant")) {
				flag = 1;

			} else if (inputLine.equalsIgnoreCase("monthly")) {
				flag = 2;

			} else if (flag == 1) {

				String str[] = inputLine.split(" ");
				String sr[] = str[0].split("[->]");

				double discount = Double.parseDouble(str[1]);

				double limitamount = Double.parseDouble(sr[1]);

				InstantSlab instantslab = new InstantSlab(limitamount, discount);
				instantSlabList.add(instantslab);

			} else if (flag == 2) {

				String str1[] = inputLine.split(" ");
				String sr1[] = str1[0].split("[->]");
				double discount = Double.parseDouble(str1[1]);
				double limitamount = Double.parseDouble(sr1[1]);
				MonthlySlab monthlySlab = new MonthlySlab(limitamount, discount);
				monthlySlabList.add(monthlySlab);

			}

		}

		List<Object> list = new ArrayList<Object>();
		list.add(instantSlabList);
		list.add(monthlySlabList);
		return list;
	}
}
