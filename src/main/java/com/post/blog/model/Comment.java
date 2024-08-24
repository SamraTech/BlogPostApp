package com.post.blog.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "comment_tbl")
@Data
@EntityListeners(AuditingEntityListener.class)

public class Comment {
	@Id
	@GeneratedValue
	@Column(name = "comt_id_col")
	private Integer comtid;
	@Column(name = "comt_content_col")
	private String content;
	@Column(name = "comt_email_col")
   private String email;
	
	@CreatedDate
	//local dat time important-----------
	private LocalDate created_on;
	private String name;
	@ManyToOne
	@JoinColumn(name="post_Id_foreign_key")
	private Post post;
		
}
