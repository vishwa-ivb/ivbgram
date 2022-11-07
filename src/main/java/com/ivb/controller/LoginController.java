package com.ivb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ivb.entity.Chats;
import com.ivb.entity.Login;
import com.ivb.entity.Notification;
import com.ivb.entity.Post;
import com.ivb.entity.Profile;
import com.ivb.others.Counter;
import com.ivb.repository.LoginDAO;
import com.ivb.repository.PostDAO;
import com.ivb.service.MessageService;
import com.ivb.service.PostService;
import com.ivb.service.ProfileService;

@Controller
public class LoginController {

	@Autowired
	LoginDAO dao;
	@Autowired
	ProfileService profiledao;
	@Autowired
	PostDAO postdao;
	@Autowired
	PostService serviceDao;
	@Autowired
	MessageService mdao;
	
	String loggedUser;
	String loggedUserPass = null;
	
	@RequestMapping(value={"/"})
	public String login() {
		return "index";
	}
	
	@RequestMapping(value={"/signin","/home"})
	public void signin(Model m, @RequestParam("uname")String uname, @RequestParam("pass")String pass) {
		
		Login username;
		String password;
			
		if(dao.existsById(uname)) 
		{
			username = dao.getReferenceById(uname);
			m.addAttribute("user", username.getUname());
			password = username.getPass();
			if(loggedUserPass == null) {
				loggedUserPass = password;
				if(loggedUserPass.equals(pass)){
					returnHome(m,uname);
				}
				else
				{
					returnIndex(m);
				}
			} 
			else if(loggedUserPass.equals(password)){
				returnHome(m,uname);
			}
			else {
				returnIndex(m);
			}
		}
		else {
			returnIndex(m);
		}
	}
	
	public String returnIndex(Model m) {
		m.addAttribute("no_acc", "! Invalid Username or Password");
		return "index";
	}
	
	public String returnHome(Model m,String uname) {
		List<Post> posts = serviceDao.getAllActivePosts();
		Collections.sort(posts,Comparator.comparingLong(Post::getId));
		Collections.reverse(posts);
		m.addAttribute("images", posts); 
		Profile profile=null;
		List <Profile> profiles = profiledao.findProfile(uname);
		for(Profile p : profiles)
		{
			profile=p;
			break;
		}
		profiledao.updatePostCount((long) profile.getPosts().size(), profile.getPid());
		m.addAttribute("profile", profile);
		loggedUser = uname;
		List<Notification> notifications = profile.getNotification();
		Collections.sort(notifications,Comparator.comparingLong(Notification::getNotiId));
		Collections.reverse(notifications);
		m.addAttribute("notifications", notifications);
		List<Chats> chats = profile.getChats();
//		Collections.sort(chats,Comparator.comparingLong(Chats::getChatId));
//		Collections.reverse(chats);
		List<Profile> proArrList = new ArrayList<Profile>();
		for(Chats c:chats) {
			String profilename = c.getChatWith();
			List <Profile> profiles2 = profiledao.findProfile(profilename);
			for(Profile p : profiles2)
			{
				proArrList.add(p);
				break;
			}
		}
		m.addAttribute("chats", proArrList);
		m.addAttribute("counter", new Counter());
		return "home";
	}
	
//	@RequestMapping(value={"/signin"},method = RequestMethod.POST)
//	public String signin(HttpServletRequest request,Model m, @RequestParam("uname")String uname, @RequestParam("pass")String pass, RedirectAttributes redirectAttributes) {
//		
//		if(uname.equals(""))
//		{
//			m.addAttribute("no_acc", "Username Required!");
//			return "index";
//		}
//		else if(pass.equals("")) 
//		{
//			m.addAttribute("no_acc", "Password Required!");
//			return "index";
//		}
//		else {
//			Login username;
//			String password;
//			Login password4home;
//			
//			if(dao.existsById(uname)) 
//			{
//				username = dao.getReferenceById(uname);
//				password4home = dao.getReferenceById(pass);
//				m.addAttribute("user", username.getUname());
//				m.addAttribute("pass", password4home.getUname());
//				password = username.getPass();
//				if(password.equals(pass))
//				{
//					redirectAttributes.addAttribute("uname", uname);
//					System.out.println("good to go");
//					return "redirect:home";
//				}
//				else
//				{
//					m.addAttribute("no_acc", "! Invalid Username or Password");
//					System.out.println("f1");
//					return "index";
//				}
//			}
//			else {
//				m.addAttribute("no_acc", "! Invalid Username or Password");
//				return "index";
//			}
//		}
//	}
//	
//	@PostMapping(value="home")
//	public ModelAndView home(Model m, @RequestParam("uname")String uname) {
//		
//			Login username;
//			
//			username = dao.getReferenceById(uname);
//			m.addAttribute("user", username.getUname());
//			List<Post> posts = serviceDao.getAllActivePosts();
//			Collections.sort(posts,Comparator.comparingLong(Post::getId));
//			Collections.reverse(posts);
//			m.addAttribute("images", posts); 
//			Profile profile=null;
//			List <Profile> profiles = profiledao.findProfile(uname);
//			for(Profile p : profiles)
//			{
//				profile=p;
//				break;
//			}
//			profiledao.updatePostCount((long) profile.getPosts().size(), profile.getPid());
//			m.addAttribute("profile", profile);
//			loggedUser = uname;
//			List<Notification> notifications = profile.getNotification();
//			Collections.sort(notifications,Comparator.comparingLong(Notification::getNotiId));
//			Collections.reverse(notifications);
//			m.addAttribute("notifications", notifications);
//			List<Chats> chats = profile.getChats();
//			List<Profile> proArrList = new ArrayList<Profile>();
//			for(Chats c:chats) {
//				String profilename = c.getChatWith();
//				List <Profile> profiles2 = profiledao.findProfile(profilename);
//				for(Profile p : profiles2)
//				{
//					proArrList.add(p);
//					break;
//				}
//			}
//			m.addAttribute("chats", proArrList);
//			m.addAttribute("counter", new Counter());
//			return new ModelAndView("home");
//			
//	}
	
	@RequestMapping("signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("createAcc")
	public String createAcc(Model m,@RequestParam("uname")String uname,@RequestParam("pass")String pass,
			@RequestParam("emailId")String emailId,@RequestParam("cpass")String cpass,
			@RequestParam("fname")String fname,@RequestParam("lname")String lname) {
		
		if(dao.existsById(uname))
		{
			m.addAttribute("create_properly_warning", "Username Unavailable!");
			return "signup";
		}
		else 
		{
			Login create = new Login(uname,pass,emailId,fname,lname);
			dao.save(create);
			Profile createProfile = new Profile(uname,emailId,fname,lname);
			profiledao.save(createProfile);
			m.addAttribute("no_acc", "Account Created Successfully!");
			return "index";
		}
	}
	
	@RequestMapping(value={"/logout"})
	public String logout(Model m) {
		loggedUser = null;
		loggedUserPass = null;
		return "redirect:/";
	}
	
//	@PostMapping("/post/search")
//	public String searchPost(Model m,@RequestParam("searchkey") String searchkey)
//	{
//		
//			List<Post> searchresults = postdao.search(searchkey);
//			//m.addAttribute("sr", searchresults);
//			for(Post p:searchresults) {
//				System.out.println(p);
//				m.addAttribute("sr", p.getAccount());
//				System.out.println(p.getAccount()+"   bad");
//				break;
//			}
//			return "profile";
//		
//	}
	
}