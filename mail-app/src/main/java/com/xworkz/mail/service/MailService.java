package com.xworkz.mail.service;

public interface MailService {

	boolean sendMailToFriend(String to, String subject, String message);
}
