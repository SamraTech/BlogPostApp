package com.post.blog.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.blog.model.Post;
import com.post.blog.model.User;
import com.post.blog.repository.UserRepository;

@Service
public class UserService {
@Autowired	
private UserRepository repository;
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		
		User save = repository.save(user);
		return "User Save With Id"+save.getUserid();
	}
	public Map<String,String> checkCredential(String email, String pwd) {
		// TODO Auto-generated method stub
		
		List<String[]> checkEmailExists = repository.checkEmailExists(email,pwd);
		Map<String, String> collect = checkEmailExists.stream().collect(Collectors.toMap(obj->obj[0].toString(), obj->obj[1].toString()));
		
		return collect;
	}
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user= repository.getUserByEmail(email);
		return user;
	}
	public User getPostWithUserByEmail(String email) {
		// TODO Auto-generated method stub
		User userByEmail = repository.getUserByEmail(email);
		return userByEmail;
	}
	public User getByUserId(Integer ptidusrid) {
		// TODO Auto-generated method stub
		Optional<User> findById = repository.findById(ptidusrid);
		
		return findById.get();
	}

}
