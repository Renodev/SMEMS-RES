package com.rnc.smems.res.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Account;
import com.rnc.smems.res.services.AccountService;

@Path("/accountremover/{id}")
public class AccountRemover {

	@Inject
	private AccountService accountService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean removeAccount (
			@PathParam("id") String id
			) {
		try {
			Account account = accountService.findByID(Long.parseLong(id));
			accountService.delete(account);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
}
