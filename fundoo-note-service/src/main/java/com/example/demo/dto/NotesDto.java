package com.example.demo.dto;

import lombok.ToString;

@ToString
public class NotesDto 
{
	private String noteTitle;
	private String content;
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public NotesDto(String noteTitle, String content) {
		super();
		this.noteTitle = noteTitle;
		this.content = content;
	}
	public NotesDto() {
		super();
	}

	
}

