package com.in.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reels implements Likeable, Commentable{

	private String caption;
	private String videoUrl;
	private Profile uploadedBy;
	private List<Comment> comments;
	private List<Like> likes;
	private LocalDateTime uploadedAt;
	
	public Reels(String caption, String videoUrl, Profile uploadedBy, List<Comment> comments, List<Like> likes,
			LocalDateTime uploadedAt) {
		super();
		this.caption = caption;
		this.videoUrl = videoUrl;
		this.uploadedBy = uploadedBy;
		this.comments = new ArrayList<>();
		this.likes = new ArrayList<>();
		this.uploadedAt = uploadedAt;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Profile getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(Profile uploadedBy) {
		this.uploadedBy = uploadedBy;
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

	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}
	
}
