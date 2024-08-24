package com.post.blog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class UserPostCommentAppApplication {

 
	public static void main(String[] args) {
		SpringApplication.run(UserPostCommentAppApplication.class, args);
	}

	

}
