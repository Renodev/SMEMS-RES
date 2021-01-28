package com.rnc.smems.res.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.smems.res.entities.Account;
import com.rnc.smems.res.enums.accountRole;

public class AccountRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (Account account) {
		entityManager.persist(account);
	}
	
	public void update (Account account) {
		entityManager.merge(account);
	}
	
	public void delete (Account account) {
		entityManager.remove(account);
	}
	
	public Account findByID (long id) {
		String str = "select t from %s t where t.id = "+id+"";
		String sql = String.format(str, Account.class.getSimpleName());
		TypedQuery<Account> query = entityManager.createQuery(sql, Account.class);
		return query.getSingleResult();
	}
	
	public Account findByUserNameAndPassword (String username, String password) {
		String str = "select t from %s t where t.username = '"+
				username+"' and t.password = '"+password+"'";
		String sql = String.format(str, Account.class.getSimpleName());
		TypedQuery<Account> query = entityManager.createQuery(sql, Account.class);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Account> findByAccountRole (accountRole accountrole) {
		String str = "select t from %s t where t.erase = false and  t.accountRole =  '"+accountrole.toString()+"'";
		String sql = String.format(str, Account.class.getSimpleName());
		TypedQuery<Account> query = entityManager.createQuery(sql, Account.class);
		return query.getResultList();
	}
	
	public List<Account> findAll() {
		String str = "select t from %s t"; // select account from account;
		String sql = String.format(str, Account.class.getSimpleName());
		TypedQuery<Account> query = entityManager.createQuery(sql, Account.class);
		return query.getResultList();
	}
	
}
