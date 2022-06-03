package com.xworkz.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.mail.service.MailService;

@Controller
@RequestMapping("/")
public class MailController {

	@Autowired
	public MailService mailService;
	public MailController() {
		System.out.println("bean created for controller");
	}
	
	@RequestMapping("/sendmail.abc")
	public String onSendClicked(@RequestParam String to, @RequestParam String subject, @RequestParam String message,Model model) {
		System.out.println("invoked onSendClicked()");
		boolean isMailSent = this.mailService.sendMailToFriend(to, subject, message);
		if(isMailSent) {
			model.addAttribute("Mail_Sent_Message", "Mail Has Sent!!!");
		}else {
			model.addAttribute("Mail_Not_Sent_Message", "Sorry!! Mail Not Sent");
		}
		return "index.jsp";
	}
}
