package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="user")
public class UserDetails 
{
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="First_name")
	@NotEmpty(message="please fill with out blank")
	private String firstname;
	
	@Column(name="Last_name")
	@NotEmpty(message="please fill with out blank")
	private String lastname;
	
	@Column(name="User_email")
	@NotEmpty(message="please fill with out blank")
	private String useremail;
	
	@Column(name="Password")
	@NotEmpty(message="please fill with out blank")
	private String password;
	
	@Column(name="Mobilenumber")
	@NotEmpty(message="please fill with out blank")
	private String mobileno;
	
	@Column(name="LocalDateTime")
	private LocalDateTime localdatetime;
	
	@Column(name="Isverified")
	private boolean isVerified;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}

	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public UserDetails(Long id, @NotEmpty(message = "please fill with out blank") String firstname,

			@NotEmpty(message = "please fill with out blank") String lastname,

			@NotEmpty(message = "please fill with out blank") String useremail,

			@NotEmpty(message = "please fill with out blank") String password,

			@NotEmpty(message = "please fill with out blank") String mobileno) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.password = password;
		this.mobileno = mobileno;
	}

	public UserDetails() {
		super();
	}
	

}
