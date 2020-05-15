package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>
{
	@Query(value="select * from user where User_email=? ",nativeQuery = true)
	UserDetails findByEmail(String useremail);
	
	@Query(value="select * from user where ID=? ",nativeQuery = true)
	UserDetails findById(long id);
	
//	@Query(value="insert into user(First_name,Last_name,User_email,Password,Mobilenumber,LocalDateTime) values(?,?,?,?,?,?)" ,nativeQuery = true)
//	void saveData(String firstname,String lastname,String useremail,String password,String mobileno,LocalDateTime localdatetime);
//	
	@Modifying
	@Query(value="Update user set Isverified =true where ID=? ",nativeQuery = true)
	void updateIsVeified(long id);
	
	@Modifying
	@Query(value="Update user set Password=? where User_email=? ",nativeQuery = true)
	void updatePassword(String password,String useremail);
	
	@Query(value="select * from user",nativeQuery = true)
	List<UserDetails> getUserList();
	

}
