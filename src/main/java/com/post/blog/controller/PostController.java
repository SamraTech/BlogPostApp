package com.post.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.post.blog.model.Post;
import com.post.blog.model.User;
import com.post.blog.service.PostService;
import com.post.blog.service.UserService;

import lombok.Delegate;

@Controller
@RequestMapping("/post")
public class PostController {
@Autowired 
private UserService ursService;
@Autowired 
private PostService pstService;
	
	@GetMapping("/newblog")
	public String createBlog(@RequestParam String email, Model model) {
		//while open blog page get User id also  
		//so through email i got userid 
		User user= ursService.getUserByEmail(email);
		model.addAttribute("post",new Post());
		
		model.addAttribute("user",user);
		
		return "blogPage";
		
	}
	@PostMapping("/save")
	public String savePost(@ModelAttribute Post post,Model model) {
		
		Post savepost = pstService.savePost(post);
		model.addAttribute("savepost",savepost);
		model.addAttribute("postbyuserid", savepost.getUser().getUserid());
		//after saving blog come to dashboard need email 
		//so post.getuser.getuserdid pass it to same page
		String email=savepost.getUser().getEmail();
		
		model.addAttribute("activemail",email);
		return "DashBoard";
		
	}
	@GetMapping("/all")
	public String getPostByUser(@RequestParam String email,Model model) {
		//to get post find id which i got by passing email of user id
		//then pass user id in post object by calling post method
		User user = ursService.getPostWithUserByEmail(email);
								
	       List<Post> postWithUser = pstService.getPostWithUser(user.getUserid());
	      	 
	      // User usermail= ursService.getUserByEmail(email);
	       model.addAttribute("postByUser",postWithUser);
	       
	       model.addAttribute("activemail",email);
	       return "DashBoard"; 
				 
	}
	@GetMapping("/delete")
	public String deletePost(@RequestParam Integer ptid,@RequestParam Integer ptidusrid,Model model) {
		
		String deletePostById = pstService.deletePostById(ptid);
		
	//get User id and find email send it to dashboard page
		User email = ursService.getByUserId(ptidusrid);
		////while going to Dashboard again we need user id
		//wwhich we call all post method 
		model.addAttribute("activemail",email.getEmail());
		return "DashBoard";	
	}
	@GetMapping("/edit")
	public String editPost(@RequestParam Integer postid,@RequestParam Integer ptidusrid,Model model) {
		
		Post postById = pstService.getPostById(postid);
		System.out.println(postById.getTitle());
	//get User id and find email send it to dashboard page
		User userId = ursService.getByUserId(ptidusrid);
		////while going to Dashboard again we need user id
		//wwhich we call all post method 
		model.addAttribute("pt",postById);
		model.addAttribute("activemail",userId.getEmail());
	//	User user= ursService.getUserByEmail(email.getEmail());
		model.addAttribute("post",new Post());
		
		model.addAttribute("user",userId);
		return "EditBlogPage";	
	}

	@GetMapping("/logout")
	public String logout() {
		
		return "indexPage";
	}
	@GetMapping("/allpost")
	public String allPost(Model model) {
		List<Post> allPost = pstService.getAllPost();
		model.addAttribute("listpost",allPost);
		return "indexPage";
	}
	@GetMapping("/postby")
	public String allpostById(@RequestParam Integer postid,Model model) {
		System.out.println("in post by");
		Post postById = pstService.getPostById(postid);
		System.out.println("in post by"+postById.getPostid());
		//System.out.println("in post by Comment"+postById.getComt());
		postById.getComt().forEach(com->System.out.println(com.getContent()));
		model.addAttribute("postById",postById);
		return "indexPage";
		
	}
	

}
