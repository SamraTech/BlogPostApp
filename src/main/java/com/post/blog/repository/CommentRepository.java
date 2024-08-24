package com.post.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.post.blog.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
	@Query("SELECT ct from Comment as ct join Post as pst  on pst.postid=ct.post  join User as usr on usr.userid=pst.user  where usr.email=:email")

	public List<Comment> getAllCommentOnPostByUser(String email);

}
