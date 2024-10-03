package com.ihub.bank.controller;

import java.util.List;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.bank.entity.Account;
import com.ihub.bank.service.AccountService;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		
	Account createAccount=service.creatAccount(account);
		return  ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	
	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
		Account account =service.getAccountDetailsByAccountNumber(accountNumber);
		 return account;
	}
	 
	@GetMapping("/getallaccount")
	public List<Account> getAllAccountDetails() {
		List<Account>allaccountdetails= service.getAllAccountDetails();
		return allaccountdetails;
	}
	
	@PutMapping("/deposit/{accountNumber}/{money}")
	public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double money) {
		Account account =service.depositAmount(accountNumber, money);
		 return account;
		
	}
	
	@PutMapping("/withdraw/{accountNumber}/{money}")
	
	public Account withdrawAccount(@PathVariable Long accountNumber, @PathVariable Double money) {
		Account account =service.withdrawAmount(accountNumber, money);
		 return account;
		
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		
		service.closeAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account closed");
		
		
	}

}
