package com.post.blog.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "post_tbl")
@EntityListeners(AuditingEntityListener.class)///use EntityListners class
@Data
public class Post {
	@Id
	@GeneratedValue
	@Column(name = "post_postid_col")
	private Integer postid;
	@Column(name = "post_title_col")
	private String title;
	@Column(name = "post_content_col")
	private String content;
	@Column(name = "post_descrp_col")
	private String description;
	@CreatedDate        //////use createdDate to know when is created
	//local dat time important-----------
	private LocalDate created_on;
	@LastModifiedDate
	private LocalDate updated_on;
	@ManyToOne
	@JoinColumn(name = "user_id_foreign_key")
	private User user; 
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comt;
}
