package com.in.dto;

import java.util.ArrayList;
import java.util.List;

public class Timeline {
	private List<Post> posts;

	public Timeline() {
		this.posts = new ArrayList<>();;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	

}
