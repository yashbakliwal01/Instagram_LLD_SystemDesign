package com.in.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.in.dto.Post;
import com.in.dto.Profile;
import com.in.interfaces.TimelineService;

public class TimelineServiceImpl implements TimelineService {

	@Override
	public List<Post> fetchTimeline(Profile profile) {
		
		//get current timeline posts that haven't been marked as seen
		List<Post> currentTimelinePosts = profile.getTimeline().getPosts();
		
		//get new celebrity posts after lastseen
		List<Post> celebrityPosts = pullCelebrityPosts(profile);
		
		//combine both lists
		List<Post> allPosts = new ArrayList<>();
		allPosts.addAll(celebrityPosts);
		allPosts.addAll(currentTimelinePosts);
		
		profile.getTimeline().setPosts(allPosts);
		return allPosts;
	}

	private List<Post> pullCelebrityPosts(Profile profile) {
		List<Profile> followings = profile.getFollowings();
		return followings.stream()
				.filter(Profile :: isCelebrity)
				.flatMap(celeb -> getPostsOfProfileAfterTime(profile.getLastSeen(), celeb.getPosts()).stream())
				.collect(Collectors.toList());
	}

	private List<Post> getPostsOfProfileAfterTime(LocalDateTime lastSeen, List<Post> posts) {
		return posts.stream()
				.filter(post->post.getCreatedAt().isAfter(lastSeen))
				.collect(Collectors.toList());
	}

	@Override
	public void addToTimeline(Post post, List<Profile> profiles) {
		profiles.stream().parallel().forEach(profile-> profile.getTimeline().getPosts().add(post));
	}

}
