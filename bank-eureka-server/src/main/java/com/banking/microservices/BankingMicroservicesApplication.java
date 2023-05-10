package com.banking.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankingMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingMicroservicesApplication.class, args);
	}

}
