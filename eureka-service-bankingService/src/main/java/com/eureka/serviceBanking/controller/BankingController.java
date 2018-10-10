package com.eureka.serviceBanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/banking")
@RefreshScope
public class BankingController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${uri:default message}")
	String uri;
	
	@Value("${uriUser:url to check if the user exists}")
	String uriUser;
	
	@GetMapping("/accounts/{num}")
	public String getBalance(@PathVariable String num){
		String url = uri+num;
		String urlUser = uriUser+num;
		boolean isUser = restTemplate.getForObject(urlUser, Boolean.class);
		String result="Unknow Account";
		if(isUser) {
		result = restTemplate.getForObject(url,String.class);
		}
		return result;
	}
	
	@GetMapping("/{id}")
	public String home(@PathVariable String id) {
		
		return uri+id;
	}

}
