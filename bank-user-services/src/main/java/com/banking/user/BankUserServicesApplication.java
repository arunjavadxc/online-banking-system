package com.banking.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableEurekaClient
public class BankUserServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUserServicesApplication.class, args);
	}

}
