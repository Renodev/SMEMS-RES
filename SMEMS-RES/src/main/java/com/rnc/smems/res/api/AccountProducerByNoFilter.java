package com.rnc.smems.res.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Account;
import com.rnc.smems.res.services.AccountService;

@Path("/accountproducerbynofilter")
public class AccountProducerByNoFilter {

	@Inject
	private AccountService accountService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> produceAccountByNoFilter () {
	return accountService.findAll();
	}
	
}
