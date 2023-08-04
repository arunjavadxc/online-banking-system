package com.bank.notification.service;

import com.bank.notification.model.MailDetail;

public interface MailService {

	String sendMail(MailDetail mailDetail);

}
