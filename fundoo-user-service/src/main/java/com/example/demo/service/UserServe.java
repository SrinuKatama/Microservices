package com.example.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResetPassword;
import com.example.demo.dto.UserDto;
import com.example.demo.model.UserDetails;

public interface UserServe
{
	UserDetails register(UserDto user) throws Exception;
	UserDetails login(LoginDto login) throws UnsupportedEncodingException;
	UserDetails forgetPasswod(String email) throws UnsupportedEncodingException;
	UserDetails mailVerification(String token);
    boolean updatePassword(ResetPassword password,String token) throws JWTVerificationException, IllegalArgumentException, Exception;
    List<UserDetails> getAllusers(String str);
	

}
