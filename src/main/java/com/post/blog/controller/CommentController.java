package com.post.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.post.blog.model.Comment;
import com.post.blog.model.User;
import com.post.blog.service.CommentService;
import com.post.blog.service.UserService;

@Controller
@RequestMapping("/comment")
public class CommentController {
@Autowired
private CommentService cmtService;
@Autowired
private UserService usrService;
	@PostMapping("/save")
	public String saveComment(@ModelAttribute Comment comt,Model model) {
		String saveComment = cmtService.saveComment(comt);	
		model.addAttribute("save",saveComment);
		
		return "indexPage";
	}
	@GetMapping("/commentall")
	public String getComments(@RequestParam String email, Model model) {
		System.out.println("in Comment");
		List<Comment> allComment = cmtService.getAllComment(email);
		
		//liscom.forEach(com->System.out.println(com));
		//System.out.println(liscom.get(index));
		model.addAttribute("comment",allComment);
		model.addAttribute("activemail",email);
		return "DashBoard";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam Integer comid,String email,Model model) {
		
		
		String deleteComment = cmtService.deleteComment(comid);
		//model.addAttribute("activemail",email);
		User userByEmail = usrService.getUserByEmail(email);
		
		model.addAttribute("activemail",userByEmail.getEmail());
		return "DashBoard";
	}
}
