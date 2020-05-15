package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.dto.NoteUpdateDto;
import com.example.demo.dto.NotesDto;
import com.example.demo.model.Notes;

@Service
public interface NoteService {
	Notes addNotes(NotesDto notes, String token,long id) throws JWTVerificationException, IllegalArgumentException, Exception;

	
	Notes updateNotes(NoteUpdateDto upnote, String token, Long noteid) throws
	  IOException, JWTVerificationException, IllegalArgumentException, Exception;
	  
	
	  boolean deletePermanent(Long noteid, String token) throws
	  JWTVerificationException, IllegalArgumentException, Exception;
	  
	
	  List<Notes> getListOfNotes(Long noteid) throws JWTVerificationException,
	  IllegalArgumentException, Exception;
	  
	/*
	 * List<Notes> sortByName(String token) throws JWTVerificationException,
	 * IllegalArgumentException, Exception;
	 */
	 
	 
}
