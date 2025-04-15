package com.in.service;

import com.in.dto.Comment;
import com.in.dto.Commentable;
import com.in.dto.Profile;
import com.in.interfaces.CommentService;

public class CommentServiceImpl implements CommentService{

//	@Override
//	public void createCommentOnPost(String description, Profile createdBy, Post post) {
//		Comment comment = new Comment(description, createdBy);
//		post.getComments().add(comment);
//	}
//
//	@Override
//	public void createCommentOnComment(String description, Profile createdBy, Comment comment) {
//		Comment childComment = new Comment(description, createdBy);
//		comment.getComments().add(childComment);
//	}

	
	public void createComment(String description, Profile createdBy, Commentable commentable) {
		Comment comment = new Comment(description, createdBy);
		commentable.getComments().add(comment);
	}
}
