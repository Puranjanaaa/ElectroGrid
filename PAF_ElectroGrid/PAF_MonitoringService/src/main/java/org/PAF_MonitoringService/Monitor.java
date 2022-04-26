package org.PAF_MonitoringService;


import java.text.SimpleDateFormat;  
import java.util.Date;  

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Monitor {
	
	//attributes
	private int accountNo;
	private int currentUnits;
	private String dateTime;
	private int additionalUnits;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
	public int getAdditionalUnits() {
		return additionalUnits;
	}
	public void setAdditionalUnits(int additionalUnits) {
		this.additionalUnits = additionalUnits;
	}
	
	
	public String getDate() {
		return dateTime;
	}
	public void setDate(String date) {
		this.dateTime = date;
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
