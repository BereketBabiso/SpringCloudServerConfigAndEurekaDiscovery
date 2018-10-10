package com.eureka.serviceAccount.model;

import lombok.Data;

@Data
public class Account {
	private String acctNumber;
	private String acctHolder;
	private double balance;
	
	public Account() {}
	public Account(String num, String name, double bal) {
		this.acctNumber=num;
		this.acctHolder = name;
		this.balance = bal;
	}
	
	
	public boolean withdraw(double amount) {
		if(balance>amount) {
			balance-=amount;
			return true;
		}
		return false;
	}
	public double checkBalance() {
		return balance;
	}

}
