package com.ElectroGrid.RedNotice;

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

@Path("redNotice")
public class RedNoticeResource {
	
	RedNoticeRepository repo = new RedNoticeRepository(); 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <RedNotice> getRedNotice()
	{
		return repo.getRedNotice();
	}
	
	@GET
	@Path("redNoticeSpdetails/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RedNotice getRedNoticee(@PathParam("id")int id)
	{ 
		return repo.getRedNotice(id);
	}
	
	
	@POST
	@Path("redNoticedetails")
	public RedNotice createRedNotice(RedNotice r1)
	{
		System.out.println(r1);
		repo.create(r1);
		
		return r1;
	}
	
	@PUT
	@Path("redNoticedetails")
	public RedNotice updateRedNotice(RedNotice r1)
	{
		
		if(repo.getRedNotice(r1.getAccountID()).getAccountID()==0) {
			
		}
		else {
			
			repo.update(r1);
		}
		
		return r1;
	}
	
	@DELETE
	@Path("redNoticeSpdetails/{id}")
	public RedNotice deleteredNotice(@PathParam("id") int id) {
		RedNotice m= repo.getRedNotice(id);
		if(m.getAccountID()!=0) {
			repo.delete(id);
		}
		
		return m;
	}

}
