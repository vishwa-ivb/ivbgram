package com.ivb.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivb.entity.Chats;
import com.ivb.entity.Message;
import com.ivb.entity.Profile;
import com.ivb.service.ChatsService;
import com.ivb.service.MessageService;
import com.ivb.service.ProfileService;

@Controller
public class MessageController {

	@Autowired
	MessageService mdao;
	@Autowired
	ProfileService pdao;
	@Autowired
	ChatsService chatsdao;
	
	@RequestMapping("/message/sent")
	public @ResponseBody ResponseEntity<?> sendMessage(Model m,@RequestParam("sender") String sender,
			@RequestParam("receiver") String receiver,@RequestParam("message") String message)
	{
		try {
			List<Message> msgArr1 = mdao.getChatHistory(sender, receiver);
			if(msgArr1.isEmpty()) {
				Profile profile = null;
				List<Profile> proList = pdao.findProfile(sender);
				for(Profile pro:proList) {
					profile = pro;
				}
				Chats chats = new Chats(receiver,profile);
				chatsdao.save(chats);
				proList = pdao.findProfile(receiver);
				for(Profile pro:proList) {
					profile = pro;
				}
				chats = new Chats(sender,profile);
				chatsdao.save(chats);
			}
			
			
			Date messageDate = new Date();
			Message msg = new Message(message,sender,receiver,messageDate,0);
			mdao.saveMessage(msg);
			List<Message> msgArr = mdao.getChatHistory(sender, receiver);
			m.addAttribute("msgs", msgArr);
			m.addAttribute("totalmsgs", msgArr.size());
			m.addAttribute("sender", sender);
			m.addAttribute("receiver", receiver);
			return new ResponseEntity<>("Post Commented Successfully", HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/message")
	public String openMessage(Model m,@RequestParam("sender") String sender,
			@RequestParam("receiver") String receiver)
	{
		Profile profile = null;
		List<Profile> proList = pdao.findProfile(receiver);
		for(Profile pro:proList) {
			profile = pro;
		}
			List<Message> msgArr = mdao.getChatHistory(sender, receiver);
			m.addAttribute("msgs", msgArr);
			m.addAttribute("totalmsgs", msgArr.size());
			m.addAttribute("sender", sender);
			m.addAttribute("fordp", profile.getPid());
			m.addAttribute("receiver", receiver);
			return "chats";
	}
	
}
