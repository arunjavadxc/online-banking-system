package com.bank.notification.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.bank.notification.utils.Constants;

@Configuration
public class GlobalConfiguration {

	@KafkaListener(id = "kafka_fsd_id", topics = Constants.TOPIC_FSD_PROJECT)
	public void listen(String message) {
		System.out.println("Message received ->" + message);
	}

}
