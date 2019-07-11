package com.novopay.hiringTest.model;

public class MonthlySlab {
	private double limitamount;
	private double discount;

	public double getLimitamount() {
		return limitamount;
	}

	public void setLimitamount(double limitamount) {
		this.limitamount = limitamount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public MonthlySlab(double limitamount, double discount) {
		super();
		this.limitamount = limitamount;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "MonthlySlab [limitamount=" + limitamount + ", discount=" + discount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(limitamount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MonthlySlab other = (MonthlySlab) obj;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (Double.doubleToLongBits(limitamount) != Double.doubleToLongBits(other.limitamount))
			return false;
		return true;
	}

}
