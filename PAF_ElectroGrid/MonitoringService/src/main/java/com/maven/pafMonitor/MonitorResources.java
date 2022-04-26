package com.maven.pafMonitor;

import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//controller class which acts as an intermediary between view and model
@Path("monitors")
public class MonitorResources {
	
	MonitorRepository repo=new MonitorRepository();
	
	//GET request to retrieve all records
	@GET 
	@Produces(MediaType.TEXT_HTML)
	public String getAllMonitors() {
		
		System.out.println("get monitor called");
		return repo.getMonitors();
	}
	
	//GET request to retrieve specific records
	@GET 
	@Path("monitor/{accNo}") /*accNo is a place holder*/
	@Produces({MediaType.APPLICATION_JSON})
	public Monitor getMonitor(@PathParam("accNo") int accNo) { /*PathParam-accNo in the url will be assigned to the parameter*/
		
		System.out.println("single monitor called");
		return repo.getMonitor(accNo);
	}
	
	 //POST request to insert a record
	@POST
	@Path("monitor")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML})
	public  Monitor createMonitor(Monitor m1) {
		
		System.out.println(m1);
		 repo.create(m1);
		 //showMessageDialog(null, "insert successful");
		return repo.getMonitor(m1.getAccountNo());
	}
	
	//PUT request to update a record
	@PUT 
	@Path("monitor")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML})
	public  Monitor updateMonitor(Monitor m1) {
		
		
		if(repo.getMonitor(m1.getAccountNo()).getAccountNo()==0) {
			System.out.println("Account no not available");
		}
		else {
			System.out.println(m1);
			repo.update(m1);
		}
		
		return repo.getMonitor(m1.getAccountNo());
	}
	
	//DELETE request to delete a record
	@DELETE 
	@Path("monitor/{accNo}")
	@Produces({MediaType.APPLICATION_XML})
	public Monitor deleteMonitor(@PathParam("accNo") int accNo) {
		
		Monitor m= repo.getMonitor(accNo);
		if(m.getAccountNo()!=0) {
			repo.delete(accNo);
		}
		
		return m;
	}
}
