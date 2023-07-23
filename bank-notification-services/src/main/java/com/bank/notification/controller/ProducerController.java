package com.bank.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.notification.service.KafkaPublisher;
import com.bank.notification.utils.Constants;

@RequestMapping(Constants.API_V1_PREFIX)
@RestController
public class ProducerController {

	@Autowired
	private KafkaPublisher kafkaPublisher;

	@GetMapping("/producer")
	public String getProducer(@RequestParam("message") String message) {
		kafkaPublisher.send(message);
		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}

	@PostMapping("/producer")
	public String postProducer(@RequestBody String message) {
		kafkaPublisher.send(message);
		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}

}
