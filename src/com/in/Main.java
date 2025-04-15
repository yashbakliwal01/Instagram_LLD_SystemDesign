package com.in;

import com.in.dto.Profile;
import com.in.interfaces.FollowRequestService;
import com.in.interfaces.PostService;
import com.in.interfaces.ReelsService;
import com.in.interfaces.TimelineService;
import com.in.service.FollowRequestServiceImpl;
import com.in.service.PostServiceImpl;
import com.in.service.ReelsServiceImpl;
import com.in.service.TimelineServiceImpl;

public class Main {

	public static void main(String[] args) {
		Profile f1 = new Profile("mayank@gmail.com", "mayank@123", "may_ank199");
		Profile f2 = new Profile("viratKohli18@gmail.com", "vk18@123", "virat_kohli");
		
		//marked f2 as celebrity
		f2.setCelebrity(true);
		
		PostService postService = new PostServiceImpl();
		TimelineService timelineService = new TimelineServiceImpl();
		FollowRequestService followRequestService = new FollowRequestServiceImpl();
		ReelsService reelsService = new ReelsServiceImpl();
		
		//send followrequest from f1 to f2
		try {
			followRequestService.createFollowRequest(f1, f2);
		}catch(Exception e) {
			 System.out.println("Exception while creating follow request: " + e.getMessage());
		}
		System.out.println("----------");
		
		//view pending requests for f2;
		System.out.println("\nFollow Requests for f2: "+followRequestService.fetchAllRequest(f2));
		System.out.println("----------");
		
		//accept followrequest
		if(!followRequestService.fetchAllRequest(f2).isEmpty()) {
			followRequestService.acceptFollowRequest(followRequestService.fetchAllRequest(f2).get(0));
		}
		
		
		//confirm follow relationship:
		System.out.println("\nAfter Accepting Request: ");
		System.out.println("Following of f2: "+ f2.getFollowers().stream().map(Profile::getEmail).toList());
		System.out.println("Followings of f1: " + f1.getFollowings().stream().map(Profile::getEmail).toList());
		System.out.println("----------");
		

		//f2 creates post
		postService.createPost(f2, "FIRST POST from VIRAT KOHLI");
		System.out.println("Posts for f2: ");
		f2.getPosts().forEach(p-> System.out.println(" - "+ p.getDescription()));
		
		System.out.println("----------");
		
		//simulate timeline fetch by f1 (follower of celebrity f2)
		//simulate f1 last seen before post creation
		if(!f2.getPosts().isEmpty()) {
			//set last seen before post creation
			f1.setLastSeen(f2.getPosts().get(0).getCreatedAt().minusMinutes(1));
		}
		
		System.out.println("Timeline for f1: ");
		System.out.println("f1 last seen: " + f1.getLastSeen());
		System.out.println("----------");
		
		timelineService.fetchTimeline(f1).forEach(p -> {
			System.out.println(" - " + p.getDescription() + " by " + p.getCreatedBy().getEmail());
		});
		
		
		//check reels service is working or not:
		
		//f2 uploads the reels
		reelsService.uploadReel(f2, "Virat's first Century in IPL 2025", "http//:reelservice.in.video_url.com");
		System.out.println("Reels for f2:");
		f2.getReels().forEach(reel->System.out.println(" - "+reel.getCaption()));
		System.out.println("----------");
		
		//f1 likes the reel;
		if(!f2.getReels().isEmpty()) {
			reelsService.likeReel(f2.getReels().get(0), f1);
		}
		
		//f1 comments on the reel;
		if(!f2.getReels().isEmpty()) {
			reelsService.commentOnReel(f2.getReels().get(0), f1, "Congrats for first Century!!!");
		}
	}
}
