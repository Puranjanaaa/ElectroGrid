package org.InquiryService;

import java.util.Arrays;
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

@Path("inquiry")
public class InquiryResource {
	
	InquiryRepository repo = new InquiryRepository(); 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <Inquiry> getRedNotice()
	{
		return repo.getInquiry();
	}
	
	@GET
	@Path("inquirySpdetails/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public Inquiry getInquiry(@PathParam("id")int id)
	{ 
		return repo.getInquiry(id);
	}
	
	
	@POST
	@Path("inquirydetails")
	public Inquiry createInquiry(Inquiry i1)
	{
		System.out.println(i1);
		repo.create(i1);
		
		return i1;
	}
	
	@PUT
	@Path("inquirydetails")
	public Inquiry updateInquiry(Inquiry i1)
	{
		
		if(repo.getInquiry(i1.getInquiryID()).getInquiryID()==0) {
			
		}
		else {
			
			repo.update(i1);
		}
		
		return i1;
	}
	
	@DELETE
	@Path("inquirySpdetails/{id}")
	public Inquiry deleteinquiry(@PathParam("id") int id) {
		Inquiry i= repo.getInquiry(id);
		if(i.getInquiryID()!=0) {
			repo.delete(id);
		}
		
		return i;
	}

}
