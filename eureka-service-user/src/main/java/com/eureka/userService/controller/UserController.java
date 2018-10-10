package com.eureka.userService.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.userService.model.User;

@RestController
@RefreshScope
@RequestMapping("/users")
public class UserController {
	
	private List<User> users;
	
	@PostConstruct
	public void init() {
		users=new ArrayList<>();
		users.add(new User("lisa","1000"));
		users.add(new User("berry","1001"));
		users.add(new User("ahmed","1002"));
	}
	
	@GetMapping
	public List<User> findAll(){
		return users;
	}
	
	@GetMapping("/{acctNum}")
	public boolean findAUser(@PathVariable String acctNum) {
		return users.stream()
					.filter(u -> acctNum.equals(u.getAcctNumber()))
					.map(u->true)
					.findFirst()
					.get();
	}
	
	

}
