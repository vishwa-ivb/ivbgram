package com.ivb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mid", nullable = false, unique = true)
	private long messageId;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "sender", nullable = false)
	private String sender;
	
	@Column(name = "receiver", nullable = false)
	private String receiver;
	
	@Column(name = "isread", nullable = false)
	private int isread;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "message_date", nullable = false)
	private Date messageDate;
	
	public Message() {
		
	}

	public Message(String message, String sender, String receiver, Date messageDate,int isread) {
		super();
		this.message = message;
		this.sender = sender;
		this.receiver = receiver;
		this.messageDate = messageDate;
		this.isread = isread;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	
	public int getIsread() {
		return isread;
	}

	public void setIsread(int isread) {
		this.isread = isread;
	}


	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + ", sender=" + sender + ", receiver="
				+ receiver + ", isread=" + isread + ", messageDate=" + messageDate + "]";
	}
	
}
