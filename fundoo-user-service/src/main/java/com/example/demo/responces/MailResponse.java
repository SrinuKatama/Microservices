package com.example.demo.responces;

import org.springframework.stereotype.Component;

@Component
public class MailResponse 
{
public String response(String url,String token) {
	return url+"/"+token;
}
}
