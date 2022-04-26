package org.InquiryService;

import jakarta.json.bind.annotation.JsonbAnnotation; 

@JsonbAnnotation 
public class Inquiry {
	
	private int InquiryID;
	private String CusName;
	private int ConNo;
	private String email;
	private String InquiryState;
	
	public int getInquiryID() {
		return InquiryID;
	}

	public void setInquiryID(int inquiryID) {
		InquiryID = inquiryID;
	}

	public String getCusName() {
		return CusName;
	}

	public void setCusName(String cusName) {
		CusName = cusName;
	}

	public int getConNo() {
		return ConNo;
	}

	public void setConNo(int conNo) {
		ConNo = conNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInquiryState() {
		return InquiryState;
	}

	public void setInquiryState(String inquiryState) {
		InquiryState = inquiryState;
	}

	@Override
	public String toString() {
		return "Inquiry [InquiryID=" + InquiryID + ", CusName=" + CusName + ", ConNo=" + ConNo + ", email=" + email
				+ ", InquiryState=" + InquiryState + "]";
	}

	

}

