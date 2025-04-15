package com.in.service;

import com.in.dto.Post;
import com.in.dto.Profile;
import com.in.interfaces.PostService;

public class PostServiceImpl implements PostService{

	private TimelineServiceImpl timelineService= new TimelineServiceImpl();
	
//	public PostServiceImpl(TimelineServiceImpl timelineService) {
//		this.timelineService = timelineService;
//	}

	@Override
	public void createPost(Profile profile, String description) {
		Post post = new Post(description, profile);
		profile.getPosts().add(post);
		if(!profile.isCelebrity()) {
			timelineService.addToTimeline(post, profile.getFollowers());
		}
//		return post;
	}

}
