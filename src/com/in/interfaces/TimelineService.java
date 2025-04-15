package com.in.interfaces;

import java.util.List;

import com.in.dto.Post;
import com.in.dto.Profile;

public interface TimelineService {
	List<Post> fetchTimeline(Profile profile);
	void addToTimeline(Post post, List<Profile> profiles);

}
