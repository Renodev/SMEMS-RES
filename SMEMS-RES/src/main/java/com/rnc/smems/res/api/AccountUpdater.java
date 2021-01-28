package com.rnc.smems.res.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Account;
import com.rnc.smems.res.enums.accountRole;
import com.rnc.smems.res.services.AccountService;

@Path("/accountupdater/{id}/{name}/{phone}/{email}/{username}/{password}/{address}/{accountRole}")
public class AccountUpdater {

	@Inject
	private AccountService accountService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean receiveAccount(
		@PathParam("id") String id,	
		@PathParam("name") String name,
		@PathParam("phone") String phone,
		@PathParam("email") String email,
		@PathParam("username") String username,
		@PathParam("password")String password,
		@PathParam("address")String address,
		@PathParam("accountRole")String accountrole
		) {
		try {
			Account account = new Account();
			account.setId(Long.parseLong(id));
			account.setName(name);
			account.setPhone(phone);
			account.setEmail(email);
			account.setUsername(username);
			account.setPassword(password);
			account.setAddress(address);
			switch(accountrole) {
			case "1": account.setAccountRole(accountRole.Admin);break;
			case "2": account.setAccountRole(accountRole.HR_Manager);break;	
			case "3": account.setAccountRole(accountRole.Warehouse);break;
			case "4": account.setAccountRole(accountRole.Accountant);break;
			default:
				break;
			}
			accountService.save(account);
			return true;
		}
		catch(Exception e) {
			return false;
			}
					
	}
	
}
