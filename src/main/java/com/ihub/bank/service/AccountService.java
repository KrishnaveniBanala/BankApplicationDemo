package com.ihub.bank.service;

import java.util.List;
import com.ihub.bank.entity.Account;

public interface AccountService{
	
	public Account creatAccount(Account account);
	
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	
	public List<Account> getAllAccountDetails();
	
	public Account depositAmount(Long accountNumber,Double money);
	
	public Account withdrawAmount(Long accountNumber,Double money);
	
	public void closeAccount(Long accountNumber);
	
	

}
