package com.eureka.serviceAccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServiceAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceAccountApplication.class, args);
	}
}
