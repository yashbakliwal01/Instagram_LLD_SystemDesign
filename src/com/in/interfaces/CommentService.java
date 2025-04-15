package com.in.interfaces;

import com.in.dto.Commentable;
import com.in.dto.Profile;

public interface CommentService {
//	public void createCommentOnPost(String description, Profile createdBy, Post post);
//	public void createCommentOnComment(String description, Profile createdBy, Comment comment);
	
	public void createComment(String description, Profile createdBy, Commentable commentable);
}
