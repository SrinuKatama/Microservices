package com.example.demo.dto;




public class UserDto 
{
	private String firstname;
	private String lastname;
	private String useremail;
	private String password;
	private String mobileno;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public UserDto(String firstname, String lastname, String useremail, String password, String mobileno) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.password = password;
		this.mobileno = mobileno;
	}
	public UserDto() {
		super();
	}
	
	

}
