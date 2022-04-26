package com.CustomerService.customerService;

import java.util.Arrays;
import java.util.List;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("customerP")
public class CustomerResource {
	
CustomerRepository repo = new CustomerRepository(); 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <Customer> getCustomer()
	{
		return repo.getCustomer();
	}
	
	@GET
	@Path("customerSpdetails/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomers(@PathParam("id")int id)
	{ 
		return repo.getCustomer(id);
	}
	
	
	@POST
	@Path("customerdetails")
	public Customer createCustomer(Customer r1)
	{
		System.out.println(r1);
		repo.create(r1);
		
		return r1;
	}
	
	@PUT
	@Path("customerdetails")
	public Customer updateCustomer(Customer r1)
	{
		
		if(repo.getCustomer(r1.getElectricityAccountNo()).getElectricityAccountNo()==0) {
			
		}
		else {
			
			repo.update(r1);
		}
		
		return r1;
	}
	
	@DELETE
	@Path("customerSpdetails/{id}")
	public Customer deleteredCustomer(@PathParam("id") int id) {
		Customer m= repo.getCustomer(id);
		if(m.getElectricityAccountNo()!=0) {
			repo.delete(id);
		}
		
		return m;
	}
	
	

}
