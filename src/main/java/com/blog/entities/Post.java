package com.blog.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {
	
	public Integer getPostId() {
		return postId;
	}


	public void setPostId(Integer postId) {
		this.postId = postId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Comment> getComments() {
		return comments;
	}


	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name= "post_title", length = 100, nullable = false)
	private String title;   
	
	@Column(length = 10000)
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	// many post can map to single category
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;  // post kis category ka h
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;         // post kis user ka h
	
	
	// using 'mappedBy' taki jo foreign key bano wo sirf 'post' table me bane
	// to avoid infinite loop.
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();


	public Post(Integer postId, String title, String content, String imageName, Date addedDate, Category category,
			User user, Set<Comment> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
		this.comments = comments;
	}


	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
}