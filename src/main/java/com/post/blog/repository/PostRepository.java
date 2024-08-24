package com.post.blog.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.post.blog.model.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{
	@Query("SELECT pst FROM Post pst JOIN pst.user as user WHERE user.userid=:userId")
	public List<Post> getPostByUser(Integer userId);
	@Query("SELECT pst FROM Post pst JOIN pst.comt as comt WHERE pst.postid=:ptid")

	public Optional<Post> findByIdWithComment(Integer ptid);

	//@Query("update Post   pst JOIN pst.user as user WHERE user.userid=:userId")

	//public Post updatePost(Integer postid, Integer ptidusrid);

	

}
