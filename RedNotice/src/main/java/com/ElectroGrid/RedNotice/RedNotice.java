package com.ElectroGrid.RedNotice;


import jakarta.json.bind.annotation.JsonbAnnotation; 

@JsonbAnnotation 
public class RedNotice {
	
	private int AccountID;
	private String CustomerName;
	private String Duedate;
	private float Units;
	private double Charges;
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getDuedate() {
		return Duedate;
	}
	public void setDuedate(String duedate) {
		Duedate = duedate;
	}
	public float getUnits() {
		return Units;
	}
	public void setUnits(float units) {
		Units = units;
	}
	public double getCharges() {
		return Charges;
	}
	public void setCharges(double charges) {
		Charges = charges;
	}
	@Override
	public String toString() {
		return "RedNotice [AccountID=" + AccountID + ", CustomerName=" + CustomerName + ", Duedate=" + Duedate
				+ ", Units=" + Units + ", Charges=" + Charges + "]";
	} 

}
