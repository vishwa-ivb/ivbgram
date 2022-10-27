package com.ivb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivb.entity.Chats;
import com.ivb.repository.ChatsDAO;

@Service
public class ChatsService {

	@Autowired
	private ChatsDAO cdao;
	
	public void save(Chats chats) {
		cdao.save(chats);
		
	}

}