package com.post.blog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_tbl")
@Data
public class User {
@Id
@GeneratedValue
@Column(name="usr_user_id_col")
private Integer userid;
@Column(name="usr_email_col")
private String email;
@Column(name="usr_fname_col")
private String fname;
@Column(name="usr_lname_col")
private String lname;
@Column(name="usr_pwd_col")
private String pwd;
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Post> post;
}
