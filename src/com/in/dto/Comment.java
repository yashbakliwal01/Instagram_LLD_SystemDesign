package com.in.dto;

import java.util.ArrayList;
import java.util.List;

public class Comment implements Likeable, Commentable{

	private String description;
	private Profile createdBy;
	private List<Comment> comments;
	private List<Like> likes;
	
	public Comment(String description, Profile createdBy) {
		super();
		this.description = description;
		this.createdBy = createdBy;
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
	
 }
