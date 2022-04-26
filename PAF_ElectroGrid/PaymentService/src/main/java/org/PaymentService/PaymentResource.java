package org.PaymentService;

import java.util.List;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("Payments")
public class PaymentResource {

	PaymentRepository repo = new PaymentRepository();

	// Read all Payments
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_HTML })
	public String getPayments() {
		System.out.println("DOne");
		return repo.getPayments();
	}

	// Read a specific record
	@GET
	@Path("Payment/{accNo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Payment getPayment(@PathParam("accNo") int accNo) {

		return repo.getPayment(accNo);
	}

	// Get units of an account
	@GET
	@Path("Units/{accNo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public double getUnits(@PathParam("accNo") int accNo) {

		return repo.getUnitsdb(accNo);
	}

	// Get additional units of an account
	@GET
	@Path("AddUnits/{accNo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public double getAddUnits(@PathParam("accNo") int accNo) {

		return repo.getAddUnitsdb(accNo);
	}

	//Get amount
	@GET
	@Path("Amount/{accNo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public double calcAmount(@PathParam("accNo") int accNo) {

		return repo.calcAmount(accNo);
	}

	
	//Create new payment record
	@POST
	@Path("Payment")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Payment createPayment(Payment p1) {

		System.out.println(p1);
		repo.create(p1);
		return p1;
	}

	//Update payment record
	@PUT
	@Path("Payment")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Payment updatePayment(Payment p1) {

		System.out.println(p1);
		if (repo.getPayment(p1.getAccNo()).getAccNo() == 0) {
			repo.create(p1);
		} else {
			repo.update(p1);
		}
		return p1;
	}

	//Update amount
	@PUT
	@Path("Amount/{accNo}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void addAmount(@PathParam("accNo") int accNo) {

		repo.addAmount(accNo);

	}

	//Delete payment record
	@DELETE
	@Path("Payment/{accNo}")
	public Payment deletePayment(@PathParam("accNo") int accNo) {
		Payment p = repo.getPayment(accNo);
		if (p.getAccNo() != 0)
			repo.delete(accNo);

		return p;
	}

	//Read monitor records from monitor service
	@GET
	@Path("ReadMonitor")
	@Produces(MediaType.TEXT_PLAIN)
	public String readMonitor() {
		return repo.readMonitor();
	}

}
