package com.example.demo.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.demo.dto.MailDto;

public class MailUtility 
{
	@Autowired
	JavaMailSender mailsender;
	
	public void sendMail(MailDto maildto)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(maildto.getEmail());
		message.setSubject(maildto.getSubject());
		message.setText(maildto.getResponse());
		mailsender.send(message);
	}

}
