package com.bank.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankNotificationServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankNotificationServicesApplication.class, args);
	}

}
