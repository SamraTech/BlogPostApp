package com.post.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.post.blog.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
@Query("SELECT email,pwd FROM User WHERE email=:email and pwd=:pwd")
	public List<String[]> checkEmailExists(String email,String pwd);
@Query("SELECT usr FROM User usr WHERE email=:email")
public User getUserByEmail(String email);

}
