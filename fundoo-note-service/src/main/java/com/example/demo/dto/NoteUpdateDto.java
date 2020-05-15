package com.example.demo.dto;

public class NoteUpdateDto
{
	private String updatenoteTitle;
	private String updatecontent;
	public String getUpdatenoteTitle() {
		return updatenoteTitle;
	}
	public void setUpdatenoteTitle(String updatenoteTitle) {
		this.updatenoteTitle = updatenoteTitle;
	}
	public String getUpdatecontent() {
		return updatecontent;
	}
	public void setUpdatecontent(String updatecontent) {
		this.updatecontent = updatecontent;
	}
	public NoteUpdateDto(String updatenoteTitle, String updatecontent) {
		super();
		this.updatenoteTitle = updatenoteTitle;
		this.updatecontent = updatecontent;
	}
	public NoteUpdateDto() {
		super();
	}
	
	

}
