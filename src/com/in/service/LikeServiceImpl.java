package com.in.service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import com.in.dto.Like;
import com.in.dto.Likeable;
import com.in.dto.Profile;
import com.in.interfaces.LikeService;

public class LikeServiceImpl implements LikeService{
	
	//this when any 2 threads comes at a time to like then need to check using multithreading
	ReentrantLock lock = new ReentrantLock();	
	
//	@Override
//	public void likeOnPost(Post post, Profile createdBy) {
//		if (!checkIfPresent(post, createdBy)) {
//			lock.lock();
//			try {
//				if (!checkIfPresent(post, createdBy)) {
//					Like like = new Like(createdBy);
//					post.getLikes().add(like);
//				}
//			}finally {
//				lock.unlock();
//			}
//		}
//	}
//
//	@Override
//	public void likeOnComment(Comment comment, Profile createdBy) {
//		if(!checkIfPresentComment(comment, createdBy)) {
//			lock.lock();
//			try {
//				if(!checkIfPresentComment(comment, createdBy)) {
//					Like like = new Like(createdBy);
//					comment.getLikes().add(like);
//				}
//			}finally {
//				lock.unlock();
//			}
//		}
//	}
//	
	public void like(Likeable likeable, Profile createdBy) {
//		if(likeable instanceof Post) {
//			((Post) likeable).getLikes().add(new Like(createdBy));
//		}else if(likeable instanceof Comment){
//			((Comment) likeable).getLikes().add(new Like(createdBy));
//		}
		if (!checkIfPresent(likeable, createdBy)) {
			lock.lock();
			try {
				if (!checkIfPresent(likeable, createdBy)) {
					Like like = new Like(createdBy);
					likeable.getLikes().add(like);
				}
			}finally {
				lock.unlock();
			}
		}
		
	}
	
	
	public void unlike(Likeable likeable, Profile createdBy) {
		if (checkIfPresent(likeable, createdBy)) {
			lock.lock();
			try {
				if (checkIfPresent(likeable, createdBy)) {
					Like likeToRemove = likeable.getLikes().stream()
							.filter(like -> like.getProfile().equals(createdBy))
							.findFirst()
							.orElse(null);
					
					if(likeToRemove!=null) {
						likeable.getLikes().remove(likeToRemove);
					}
				}
			}finally {
				lock.unlock();
			}
		}

	}

//	@Override
//	public void unlikeOnPost(Post post, Profile createdBy) {
//		if(!checkIfPresent(post, createdBy)) {
//			lock.lock();
//			try {
//				if(!checkIfPresent(post, createdBy)) {
//					Like like = new Like(createdBy);
//					post.getLikes().remove(like);
//				}
//			}finally {
//				lock.unlock();
//			}
//		}
//	}
//
//	@Override
//	public void unlikeOnComment(Comment comment, Profile createdBy) {
//		if(!checkIfPresentComment(comment, createdBy)) {
//			lock.lock();
//			try {
//				if(!checkIfPresentComment(comment, createdBy)) {
//					Like like = new Like(createdBy);
//					comment.getLikes().remove(like);
//				}
//			}finally {
//				lock.unlock();
//			}
//		}
//	}

	private boolean checkIfPresent(Likeable likeable, Profile profile) {
		List<Like> likes = likeable.getLikes();
		return likes.stream().parallel().filter(like-> like.getProfile().equals(profile)).findFirst().isPresent();
	}
	
//	private boolean checkIfPresentComment(Likeable likeable, Profile profile) {
//		List<Like> likes = likeable.getLikes();
//		return likes.stream().parallel().filter(like->like.getProfile().equals(profile)).findFirst().isPresent();
//	}
}
