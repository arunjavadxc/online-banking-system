package com.bank.notification.model;

import lombok.Data;

@Data
public class KafkaMessage {

	private String mailID;
	private String subject;
	private String message;
}
