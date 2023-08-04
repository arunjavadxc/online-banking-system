package com.bank.notification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bank.notification.model.KafkaMessage;
import com.bank.notification.model.MailDetail;
import com.bank.notification.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerApi {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerApi.class);

	@Autowired
	private MailService mailService;

	@KafkaListener(topics = Constants.TOPIC_FSD_PROJECT, groupId = Constants.GROUP_ID)
	public void consume(String message) {
		log.info(String.format("Message received -> %s", message));

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			KafkaMessage kafkaMessage = objectMapper.readValue(message, KafkaMessage.class);
			mailService.sendMail(getMailDetail(kafkaMessage));
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public MailDetail getMailDetail(KafkaMessage kafkaMessage) {
		MailDetail mailDetail = new MailDetail();
		mailDetail.setMsgBody(kafkaMessage.getMessage());
		mailDetail.setRecipient(kafkaMessage.getMailID());
		mailDetail.setSubject(kafkaMessage.getSubject());
		return mailDetail;
	}

}
