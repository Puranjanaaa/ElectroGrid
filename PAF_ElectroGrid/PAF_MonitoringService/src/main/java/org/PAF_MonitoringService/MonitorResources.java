package org.PAF_MonitoringService;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("monitors")
public class MonitorResources {

	MonitorRepository repo = new MonitorRepository();

	// GET request to retrieve all records
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getAllMonitors() {

		System.out.println("get monitor called");
		return repo.getMonitors();
	}

	@GET
	@Path("monitor/{accNo}") /* accNo is a place holder */
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Monitor getMonitor(
			@PathParam("accNo") int accNo) { /* PathParam-accNo in the url will be assigned to the parameter */

		System.out.println("single monitor called");
		return repo.getMonitor(accNo);
	}

	@POST
	@Path("monitor")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Monitor createMonitor(Monitor m1) {

		System.out.println(m1);
		repo.create(m1);
		return m1;
	}

	@PUT
	@Path("monitor")
	public Monitor updateMonitor(Monitor m1) {

		if (repo.getMonitor(m1.getAccountNo()).getAccountNo() == 0) {
			System.out.println("Account no not available");
		} else {
			System.out.println(m1);
			repo.update(m1);
		}

		return m1;
	}

	@DELETE
	@Path("monitor/{accNo}")
	public Monitor deleteMonitor(@PathParam("accNo") int accNo) {
		Monitor m = repo.getMonitor(accNo);
		if (m.getAccountNo() != 0) {
			repo.delete(accNo);
		}

		return m;
	}
	

	@GET
	@Path("/ReadBill/{AccNo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String readItems(@PathParam("AccNo") int AccountNumber,@PathParam("Month") int Month) {
	return repo.readBill(AccountNumber,Month);
	}
}
