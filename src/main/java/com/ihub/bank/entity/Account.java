package com.ihub.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;
	@Column
	private String accountHolderName;
	@Column
	private double money;
	private Double totalBalance;
	
	

	/**
	 * 
	 */
	public Account() {
		super();
	}
	/**
	 * @param accountHolderName
	 * @param money
	 */
	public Account(Long accountNumber, String accountHolderName, double money) {
		this.accountNumber=accountNumber;
		this.accountHolderName = accountHolderName;
		this.money = money;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setId(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Double getAccount_balance() {
		
		return money;
	}
	public void setAccount_balance(Double  money) {
		this.money= money;
		
	}
	
	
	
	
	
	

}
