package com.ivb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ivb.entity.Chats;
import com.ivb.entity.Comments;
import com.ivb.entity.Post;

@Repository
public interface ChatsDAO extends JpaRepository<Chats, Long>{
	
//	@Transactional 
//	@Modifying 
//	@Query("select c from Chats c where c.chatwith = ?1 AND c.profile = ?2") 
//	public List<Chats> checkChats(String chatwith,);
	
}
