package com.CustomerService.customerService;

import jakarta.json.bind.annotation.JsonbAnnotation; 

@JsonbAnnotation 

public class Customer {
	
	private int ElectricityAccountNo;
	private String CustomerName;
	private String CustomerAddress;
	private int PremisesID;
	
	public int getElectricityAccountNo() {
		return ElectricityAccountNo;
	}

	public void setElectricityAccountNo(int electricityAccountNo) {
		ElectricityAccountNo = electricityAccountNo;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public int getPremisesID() {
		return PremisesID;
	}

	public void setPremisesID(int premisesID) {
		PremisesID = premisesID;
	}

	@Override
	public String toString() {
		return "Customer [ElectricityAccountNo=" + ElectricityAccountNo + ", CustomerName=" + CustomerName
				+ ", CustomerAddress=" + CustomerAddress + ", PremisesID=" + PremisesID + "]";
	}

}
