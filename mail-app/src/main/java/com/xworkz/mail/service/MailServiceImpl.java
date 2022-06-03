package com.xworkz.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;

	public MailServiceImpl() {
		super();
		System.out.println("bean for serviceImpl created");
	}

	@Override
	public boolean sendMailToFriend(String to, String subject, String message) {

		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setText(message);
			mailMessage.setSubject(subject);
			mailSender.send(mailMessage);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

}
