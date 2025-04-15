package com.in.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post implements Likeable, Commentable{
	private String description;
	private Profile createdBy;
	private List<Comment> comments;
	private List<Like> likes;
	private LocalDateTime createdAt;
	
	public Post(String description, Profile createdBy) {
		super();
		this.description = description;
		this.createdBy = createdBy;
		createdAt = LocalDateTime.now();
		comments = new ArrayList<>();
		likes = new ArrayList<>();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Profile getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Profile createdBy) {
		this.createdBy = createdBy;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}
