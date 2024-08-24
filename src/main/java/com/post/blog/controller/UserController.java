package com.post.blog.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.post.blog.model.User;
import com.post.blog.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService usrService;
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user,Model model) {
		String saveUserid = usrService.saveUser(user);
		model.addAttribute("saveUserid", saveUserid);
		return "indexPage";
	}

	@GetMapping("/register")
	public String registerUser(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		System.out.println("in register");
		return "RegisterUser";
	}
	@GetMapping("/login")
	public String loginUser(Model model) {
		
		return "LoginForm";
	}
	@PostMapping("/checkemail")
	public String checkCredentials(HttpServletRequest request,Model model) {
		String msg="";
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		//logic to see email verification--------------
		Map<String, String> map = usrService.checkCredential(email,pwd);
		String pwdemail = map.get(email);
		if (pwdemail.equals(pwd)) {
			msg="DashBoard";
		}
		else {
			msg="indexPage";	
		}
		//----------------------------------------------
		model.addAttribute("msg",msg);
		model.addAttribute("activemail",email);
		return msg;
	}
	
}
