package com.payment.Payment_Management;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("Payment")
public class PaymentResource {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Payment getPayment() {
		System.out.println("DOne");
		Payment p1 = new Payment();
		p1.setAccNo("1001");
		p1.setUnits("100");
		p1.setAdditionalUnit("2");
		p1.setAmount("23456");
		p1.setDueDate("21/5/2022");
		p1.setPricePerUnit("240");
		
		Payment p2 = new Payment();
		p2.setAccNo("1002");
		p2.setUnits("100");
		p2.setAdditionalUnit("5");
		p2.setAmount("79548");
		p2.setDueDate("27/2/2022");
		p2.setPricePerUnit("240");
		
		return p1,p2	;
	}
}
