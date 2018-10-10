package com.eureka.serviceBanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServiceBankingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceBankingServiceApplication.class, args);
	}
}
