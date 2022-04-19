package com.payment.Payment_Management;

import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Payment {
	private String units;
	private String accNo;
	private String dueDate;
	private String amount;
	private String pricePerUnit;
	private String additionalUnit;
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public String getAdditionalUnit() {
		return additionalUnit;
	}
	public void setAdditionalUnit(String additionalUnit) {
		this.additionalUnit = additionalUnit;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
}
