package com.example.demo.dto;

import java.time.LocalDateTime;





public class RemaindDto 
{
	private LocalDateTime localdatetime;
	private String  place;
	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}
	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public RemaindDto(LocalDateTime localdatetime, String place) {
		super();
		this.localdatetime = localdatetime;
		this.place = place;
	}
	public RemaindDto() {
		super();
	}
	
	

}
