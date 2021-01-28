package com.rnc.smems.res.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Account;
import com.rnc.smems.res.enums.accountRole;
import com.rnc.smems.res.services.AccountService;

@Path("/accountproducerbyposition/{accountRoleID}")
public class AccountProducerByPosition {

	@Inject
	private AccountService accountService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> produceAccountByPosition (@PathParam("accountRoleID") String accountRoleID) {
		if (accountRoleID.equals("1")) {
			return accountService.findByAccountRole(accountRole.Admin);
		} else if (accountRoleID.equals("2")) {
			return accountService.findByAccountRole(accountRole.HR_Manager);
		} else if (accountRoleID.equals("3")) {
			return accountService.findByAccountRole(accountRole.Warehouse);
		} else if (accountRoleID.equals("4")) {
			return accountService.findByAccountRole(accountRole.Accountant);
		} else {
			return null;
		}
	}

	
}
