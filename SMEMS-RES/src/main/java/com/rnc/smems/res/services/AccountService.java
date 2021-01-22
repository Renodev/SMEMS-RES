package com.rnc.smems.res.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.smems.res.entities.Account;
import com.rnc.smems.res.repositories.AccountRepository;

@LocalBean
@Stateless
public class AccountService {
	
	@Inject
	private AccountRepository accountRepository;
	
	public void save (Account account) {
		if (account.getId() == 0) {
			accountRepository.save(account);
		} else {
			accountRepository.update(account);
		}
	}
	
	public void delete (Account account) {
		Account acc = findByID(account.getId());
		accountRepository.delete(acc);
	}
	
	public Account findByID (long id) {
		return accountRepository.findByID(id);
	}
	
	public Account findByUserNameAndPassword (String username, String password) {
		return accountRepository.findByUserNameAndPassword(username, password);
	}
	
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
		
}
