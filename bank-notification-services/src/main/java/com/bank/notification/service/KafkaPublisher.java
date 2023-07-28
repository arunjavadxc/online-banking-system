package com.bank.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisher {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	String kafkaTopic = "fsd-project";

	public void send(String message) {

		kafkaTemplate.send(kafkaTopic, message);
	}
}
