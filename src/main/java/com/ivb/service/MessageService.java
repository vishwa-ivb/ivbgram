package com.ivb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivb.entity.Message;
import com.ivb.repository.MessageDAO;

@Service
public class MessageService {

	@Autowired
	private MessageDAO mdao;
	
	public void saveMessage(Message message) {
		mdao.save(message);	
	}
	
	public List<Message> getChatHistory(String sender, String receiver){
		return mdao.getChatHistory(sender, receiver);
	}

}
