package com.post.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.blog.model.Comment;
import com.post.blog.model.Post;
import com.post.blog.repository.PostRepository;

@Service
public class PostService {
@Autowired
private PostRepository repository;
private List<Post> postByUser;

	public Post savePost(Post post) {
		// TODO Auto-generated method stub
		 Post save = repository.save(post);
		 return save;
	}

	public List<Post> getPostWithUser(Integer userid) {
		// TODO Auto-generated method stub
		
		postByUser = repository.getPostByUser(userid);
		return 
				postByUser;
	}

	public String deletePostById(Integer postid) {
		// TODO Auto-generated method stub
		String msg="";
		if(repository.findById(postid).get().getPostid()==postid) {
			repository.deleteById(postid);
			msg="deleted Post by Id"+postid;
		}
		else{
			msg=" Post  not found  Id"+postid;
		};
		return msg;
		
		
	}

	public Post getPostById(Integer ptid) {
		// TODO Auto-generated method stub
		System.out.println("in post Service");
		Optional<Post> findById = repository.findById(ptid);
		System.out.println("repo return"+findById.get().getPostid());
		List<Comment> comt = findById.get().getComt();
		for(Comment ct:comt) {
			System.out.println(ct.getName());
		}
		
		return findById.get();
	}

	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		List<Post> allpost = repository.findAll();
		return allpost;
	}

	

	
}
