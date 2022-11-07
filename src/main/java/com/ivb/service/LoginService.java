package com.ivb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivb.repository.LoginDAO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO dao;
	
	public void updateEmailId(String emailId, String uname) {
		dao.updateEmailId(emailId, uname);
	}
	
	public void updatePassword(String pass, String uname) {
		dao.updatePassword(pass, uname);
	}
	
	public void ivbSave(String uname, String pass, String emailId, String fname, String lname) {
		dao.ivbSave(uname, pass, emailId, fname, lname);
	}
}