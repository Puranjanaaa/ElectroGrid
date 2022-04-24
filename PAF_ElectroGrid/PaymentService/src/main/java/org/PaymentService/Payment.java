package org.PaymentService;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {
	private String units;
	private String additionalUnits;
	public String getAdditionalUnits() {
		return additionalUnits;
	}
	public void setAdditionalUnits(String additionalUnits) {
		this.additionalUnits = additionalUnits;
	}
	private int accNo;
	private String dueDate;
	private String amount;
	public  String pricePerUnit;
	private String additionalUnitPrice;
	
	
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
	public String getAdditionalUnitPrice() {
		return additionalUnitPrice;
	}
	public void setAdditionalUnitPrice(String additionalUnitPrice) {
		this.additionalUnitPrice = additionalUnitPrice;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "Payment [accNo=" + accNo + ", amount=" + amount + ", pricePerUnit=" + pricePerUnit + ", additionalUnits="
				+ additionalUnits + ", dudeDate=" + dueDate + "]";
	}
	
}
