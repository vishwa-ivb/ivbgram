package com.ivb.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="profiles")
public class Profile {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid", nullable = false, unique = true)
	private Long pid;
	
	@Column(name = "account", nullable = false, unique = true)
	private String account;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Lob
    @Column(name = "profilepic", length = Integer.MAX_VALUE, nullable = true)
    private byte[] profilepic;
	
	@Column(name = "about", nullable = true)
	private String about;
	
	@Column(name = "postscount", nullable = true)
	private Long postscount;
	
	@OneToMany(mappedBy="profile")
	@Column(name = "posts",nullable = false)
	private List<Post> posts = new ArrayList<Post>();
	
	@OneToMany(mappedBy="profileNoti")
	@Column(name = "notification",nullable = false)
	private List<Notification> notification = new ArrayList<Notification>();
	
	@OneToMany(mappedBy="profile")
	@Column(name = "chats",nullable = true)
	private List<Chats> chats = new ArrayList<Chats>();
	
	@Column(name = "fname", nullable = true)
	private String fname;
	
	@Column(name = "lname", nullable = true)
	private String lname;
	
	public Profile()
	{
		
	}
	
	public Profile(String account, String email,String fname, String lname) {
		super();
		this.account = account;
		this.email = email;
		this.postscount=0l;
		this.fname=fname;
		this.lname=lname;
	}

	public List<Chats> getChats() {
		return chats;
	}

	public void setChats(List<Chats> chats) {
		this.chats = chats;
	}

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(byte[] profilepic) {
		this.profilepic = profilepic;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Long getPostscount() {
		return postscount;
	}

	public void setPostscount(Long postscount) {
		this.postscount = postscount;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Profile [pid=" + pid + ", account=" + account + ", email=" + email + ", profilepic="
				+ Arrays.toString(profilepic) + ", about=" + about + ", postscount=" + postscount + ", posts=" + posts
				+ ", notification=" + notification + ", chats=" + chats + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
}
