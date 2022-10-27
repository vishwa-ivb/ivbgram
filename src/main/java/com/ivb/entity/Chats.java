package com.ivb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chats {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chatid", nullable = false, unique = true)
	private long chatId;
	
	@Column(name = "chatwith", nullable = false)
	private String chatWith;
	
	@ManyToOne(targetEntity = Profile.class)
	@JoinColumn(name="profile", nullable = false)
	private Profile profile;

	public Chats() {
		
	}

	public Chats(String chatWith, Profile profile) {
		super();
		this.chatWith = chatWith;
		this.profile = profile;
	}

	public long getChatId() {
		return chatId;
	}

	public void setChatId(long chatId) {
		this.chatId = chatId;
	}

	public String getChatWith() {
		return chatWith;
	}

	public void setChatWith(String chatWith) {
		this.chatWith = chatWith;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Chats [chatId=" + chatId + ", chatWith=" + chatWith + ", profile=" + profile + "]";
	}
	
}

