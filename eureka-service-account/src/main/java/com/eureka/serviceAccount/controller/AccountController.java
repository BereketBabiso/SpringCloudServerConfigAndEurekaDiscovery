package com.eureka.serviceAccount.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.serviceAccount.model.Account;

@RestController
@RefreshScope
@RequestMapping("/accounts")
public class AccountController {
	
	List<Account> accounts;
	
	@PostConstruct
	public void init() {
		accounts = new ArrayList<>();
		accounts.add(new Account("1000","lisa",2000));
		accounts.add(new Account("1001","berry",2600));
		accounts.add(new Account("1002","ahmed",2070));
	}
	
	@GetMapping
	public List<Account> findAll(){
		return accounts;
	}
	
	@GetMapping("/balance/{acctNum}")
	public String balance(@PathVariable String acctNum) {
		return accounts.stream()
					   .filter(a->acctNum.equals(a.getAcctNumber()))
					   .map(a->a.getBalance())
					   .findFirst().get().toString();

	}

}
