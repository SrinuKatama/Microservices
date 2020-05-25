package com.example.demo.serviceimplementation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.dto.NoteUpdateDto;
import com.example.demo.dto.NotesDto;
import com.example.demo.model.Notes;
import com.example.demo.repository.NotesRepository;
import com.example.demo.service.NoteService;

@Service
public class NoteServiceimp implements NoteService {
	Notes noteentity = new Notes();

	@Autowired
	NotesRepository noterepository;

	@Override
	public Notes addNotes(NotesDto notes, String token, long id)
			throws JWTVerificationException, IllegalArgumentException, Exception

	{
		noteentity.setPin(false);
		noteentity.setArchive(false);
		noteentity.setColor("white");
		noteentity.setNoteid(id);
		noteentity.setNoteTitle(notes.getNoteTitle());
		noteentity.setContent(notes.getContent());
		noteentity.setTrash(false);
		noterepository.addNotes(noteentity.getNoteTitle(), noteentity.getContent(), LocalDateTime.now(),
				noteentity.getNoteid());
		return noteentity;

	}

	@Override
	public Notes updateNotes(NoteUpdateDto upnote, String token, Long noteid)
			throws IOException, JWTVerificationException, IllegalArgumentException, Exception {

		Notes not = noterepository.findByNoteId(noteid);
		if (not != null) {
			not.setNoteTitle(upnote.getUpdatecontent());
			not.setNoteTitle(upnote.getUpdatenoteTitle());
			noterepository.updateNotes(not.getNoteTitle(), not.getContent(), noteid);
			return not;
		} else {
			return null;
		}
	}

	@Override
	public boolean deletePermanent(Long noteid, String token)
			throws JWTVerificationException, IllegalArgumentException, Exception {
		Notes not = noterepository.findByNoteId(noteid);
		if (not != null) {
			noterepository.deleteNotes(noteid);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Notes> getListOfNotes(Long noteid)
			throws JWTVerificationException, IllegalArgumentException, Exception {

		return noterepository.getListOfNotes(noteid);
	}

}


