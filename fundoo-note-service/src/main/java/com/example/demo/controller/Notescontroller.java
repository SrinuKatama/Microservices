package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.dto.NoteUpdateDto;
import com.example.demo.dto.NotesDto;
import com.example.demo.model.UserDetails;
import com.example.demo.responces.Responses;
import com.example.demo.serviceimplementation.NoteServiceimp;

@RestController
public class Notescontroller 
{
	@Autowired
	private NoteServiceimp noteserve;
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Value("${note.getuser}")
	private String getUser;
	
	public UserDetails getUser(String token)
	{
		UserDetails user=resttemplate.getForObject(getUser+token,UserDetails.class );
		return user;
		
	}

	// API for creating note
	@PostMapping(value = "notes/create")
	public ResponseEntity<Responses> addNotes(@RequestBody NotesDto not1, @RequestHeader String token)
			throws JWTVerificationException, IllegalArgumentException, Exception {
		UserDetails user1 = getUser(token);
		if (user1 != null) {
			noteserve.addNotes(not1, token, user1.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(new Responses("note created", 200));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("uable to create", 400, not1));

		}

	}
	
	// API for delete the note
	
	@DeleteMapping(value = "notes/delete/{noteid}")
	public ResponseEntity<Responses> deketeNote(@PathVariable Long noteid,@RequestHeader String token) throws JWTVerificationException, IllegalArgumentException, Exception
	{
		UserDetails user1 = getUser(token);
		if(user1!=null)
		{
			noteserve.deletePermanent(noteid, token);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("deleted successfully", 200));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("unable to delete", 400));
		}

		
	}
	
	//API for update note
	
	@PutMapping(value = "notes/updateNote/{noteid}")
	public ResponseEntity<Responses> updateNote(@RequestBody NoteUpdateDto upnote,@PathVariable Long noteid,@RequestHeader String token) throws JWTVerificationException, IllegalArgumentException, IOException, Exception
	{
		UserDetails user1 = getUser(token);
		if(user1!=null)
		{
			noteserve.updateNotes(upnote, token, noteid);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("updated successfully", 200));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("uable to update", 400));
		}

		
	}
	
	@GetMapping(value ="notes/getlistofnotes")
	public ResponseEntity<Responses> getListOfNotes(@RequestHeader String token) throws JWTVerificationException, IllegalArgumentException, Exception
	{
		UserDetails user1 = getUser(token);
		if(user1!=null)
		{
			noteserve.getListOfNotes(user1.getId());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Responses("successfully getting the details", 200));
		}

		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("uable to fecthing the data", 400));

		}
		
	}
	
	

}
