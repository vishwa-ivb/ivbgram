package com.ivb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ivb.entity.Login;

@Repository
public interface LoginDAO extends JpaRepository<Login, String>{
	
	@Transactional 
	@Modifying 
	@Query(value="update Login l set l.emailId = ?1 where l.uname = ?2") 
	public void updateEmailId(String emailId, String uname);

	@Transactional 
	@Modifying 
	@Query(value="update Login l set l.pass = ?1 where l.uname = ?2") 
	public void updatePassword(String pass, String uname);
	
	@Transactional 
	@Modifying 
	@Query(value="insert into login values(?1,(AES_ENCRYPT(?2,?1)),?3,?4,?5)",nativeQuery = true) 
	public void ivbSave(String uname, String pass, String emailId, String fname, String lname);

}
