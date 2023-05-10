package com.banking.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TransactionServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionServicesApplication.class, args);
	}

}
