package com.bank.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankUiOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUiOauthApplication.class, args);
	}

}
