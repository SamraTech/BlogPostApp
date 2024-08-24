package com.post.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.post.blog.model.Comment;
import com.post.blog.service.PostService;
import com.post.blog.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private UserService usrervice;
	@Autowired
	private PostService postrvice;
	
@GetMapping("/index")
public String index(Model model) {
	//List<Post> allPost = postrvice.getAllPost();
	Comment comt=new Comment();
	model.addAttribute("comt", comt);
	return "indexPage";
}
}
