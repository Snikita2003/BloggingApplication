package com.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Integer id;
	
	private String content;
	
	@ManyToOne
	private Post post;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Integer id, String content, Post post) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
	}
	
	
	
}