package org.PaymentService;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {
	private double units;
	private double additionalUnits;
	private int accNo;
	private String dueDate;
	private double amount;
	public static double unitPrice = 18.00;
	public static double additionalUnitPrice = 25.00;
	public static double fixedAmount = 450.00;
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getUnits() {
		return units;
	}
	public void setUnits(double units) {
		this.units = units;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public double getAdditionalUnits() {
		return additionalUnits;
	}
	public void setAdditionalUnits(double additionalUnits) {
		this.additionalUnits = additionalUnits;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "Payment [accNo=" + accNo + ", amount=" + amount + ", pricePerUnit="  + ", additionalUnits="
				+ additionalUnits + ", dudeDate=" + dueDate + "]";
	}
	
}
