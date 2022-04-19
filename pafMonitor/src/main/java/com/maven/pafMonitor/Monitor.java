package com.maven.pafMonitor;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Monitor {
	
	private int accountNo;
	private int currentUnits;
	private String date;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getCurrentUnits() {
		return currentUnits;
	}
	public void setCurrentUnits(int currentUnits) {
		this.currentUnits = currentUnits;
	}
	
	
	

}
