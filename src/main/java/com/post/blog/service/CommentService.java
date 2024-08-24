package com.post.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.blog.model.Comment;
import com.post.blog.repository.CommentRepository;

@Service
public class CommentService {
@Autowired
private CommentRepository cmtRepository;
	public String saveComment(Comment comt) {
		// TODO Auto-generated method stub
		Comment save = cmtRepository.save(comt);
		return "Comment save"+save.getComtid();
	}
	public List<Comment> getAllComment(String email) {
		// TODO Auto-generated method stub
		//List<Comment> allComment = cmtRepository.findAll();
		List<Comment> allCommentOnPostByUser = cmtRepository.getAllCommentOnPostByUser(email);
		System.out.println("in service after query");
		
		return allCommentOnPostByUser;
	}
	public String deleteComment(Integer comid) {
		// TODO Auto-generated method stub
		String msg="";
		if(cmtRepository.findById(comid).get().getComtid()==comid) {
			cmtRepository.deleteById(comid);
			msg="Deleted";
		}
		else {
			msg=" Not Deleted";
		}
		return msg;
		
	}

	
}
