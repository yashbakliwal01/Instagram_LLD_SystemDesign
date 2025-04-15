package com.in.interfaces;

import com.in.dto.Likeable;
import com.in.dto.Profile;

public interface LikeService {
//	void likeOnPost(Post post, Profile createdBy);
//	void likeOnComment(Comment comment, Profile createdBy);
//	void unlikeOnPost(Post post, Profile createdBy);
//	void unlikeOnComment(Comment comment, Profile createdBy);
//}
	
	void like(Likeable likeable, Profile createdBy);
	void unlike(Likeable likeable, Profile createdBy);
}
