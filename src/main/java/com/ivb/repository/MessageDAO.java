package com.ivb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ivb.entity.Message;

public interface MessageDAO extends JpaRepository<Message, Long>{
	
	@Transactional 
	@Modifying 
	@Query("select m from Message m where (m.sender = ?1 AND m.receiver = ?2) OR (m.sender = ?2 AND m.receiver = ?1)")// SELECT * FROM pet WHERE (species = 'cat' AND sex = 'm')
	public List<Message> getChatHistory(String sender, String receiver);

}
