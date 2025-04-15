package com.in.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.in.dto.Comment;
import com.in.dto.Like;
import com.in.dto.Profile;
import com.in.dto.Reels;
import com.in.interfaces.ReelsService;

public class ReelsServiceImpl implements ReelsService{

	@Override
	public void uploadReel(Profile profile, String caption, String videoUrl) {
		Reels newReel = new Reels(caption, videoUrl, profile, new ArrayList<>(), new ArrayList<>(), LocalDateTime.now());
		profile.getReels().add(newReel);
		System.out.println("Reel uploaded by "+profile.getEmail()+"with caption: " + caption);
	}

	@Override
	public void likeReel(Reels reel, Profile profile) {
		//check if user already like the reel
		if(!isReelLikedByUser(reel, profile)) {
			Like newLike = new Like(profile);
			reel.getLikes().add(newLike);
			System.out.println(profile.getEmail()+" liked the reel with caption: "+ reel.getCaption());
		}else {
			System.out.println(profile.getEmail()+" has already liked this reel.");
		}
		
	}

	private boolean isReelLikedByUser(Reels reel, Profile profile) {
		return reel.getLikes().stream().anyMatch(like->like.getProfile().equals(profile));
	}

	@Override
	public void commentOnReel(Reels reel, Profile profile, String commentText) {
		Comment newComment = new Comment(commentText, profile);
		reel.getComments().add(newComment);
		System.out.println(profile.getEmail()+" commented on the reel: "+ commentText);
	}

}
