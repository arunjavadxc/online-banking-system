package com.banking.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankUserServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUserServicesApplication.class, args);
	}

}
