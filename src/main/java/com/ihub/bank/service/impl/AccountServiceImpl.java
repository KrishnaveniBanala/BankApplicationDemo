package com.ihub.bank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.bank.entity.Account;
import com.ihub.bank.repository.AccountRepository;
import com.ihub.bank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository repository;

	@Override
	public Account creatAccount(Account account) {
		Account account_saved = repository.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account>account=repository.findById(accountNumber);
		
		if(account.isEmpty()) {
			throw new RuntimeException("Account does not present");
		}
		Account account_found = account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account>listofaccounts = repository.findAll();
		return listofaccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double money) {
		Optional<Account> account=repository.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
			}
		Account accountPresent=account.get();
		Double totalBalance = accountPresent.getAccount_balance()+money;
		accountPresent.setAccount_balance(totalBalance);
		repository.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double money) {
		Optional<Account> account=repository.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
			}
		Account accountPresent=account.get();
		Double AccountBalance=accountPresent.getAccount_balance()-money;
		accountPresent.setAccount_balance(AccountBalance);
		repository.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
	
		getAccountDetailsByAccountNumber(accountNumber);
		repository.deleteById(accountNumber);
		
	}
	
	
	
	

}
