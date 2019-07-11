package com.novopay.hiringTest.model;

public class TransactionRecord {
	private int date;
	private int month;
	private int year;
	private double transactionAmount;
	private double instantDiscount;

	public double getInstantDiscount() {
		return instantDiscount;
	}

	public void setInstantDiscount(double instantDiscount) {
		this.instantDiscount = instantDiscount;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionRecord(int date, int month, int year, double transactionAmount) {
		super();
		this.date = date;
		this.month = month;
		this.year = year;
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "TransactionRecord [date=" + date + ", month=" + month + ", year=" + year + ", transactionAmount="
				+ transactionAmount + ", instantDiscount=" + instantDiscount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + date;
		long temp;
		temp = Double.doubleToLongBits(instantDiscount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + month;
		temp = Double.doubleToLongBits(transactionAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionRecord other = (TransactionRecord) obj;
		if (date != other.date)
			return false;
		if (Double.doubleToLongBits(instantDiscount) != Double.doubleToLongBits(other.instantDiscount))
			return false;
		if (month != other.month)
			return false;
		if (Double.doubleToLongBits(transactionAmount) != Double.doubleToLongBits(other.transactionAmount))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
