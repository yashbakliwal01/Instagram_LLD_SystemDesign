package com.in.interfaces;

import com.in.dto.Profile;
import com.in.dto.Reels;

public interface ReelsService {

	void uploadReel(Profile profile, String caption, String videoUrl);
	void likeReel(Reels reel, Profile profile);
	void commentOnReel(Reels reel, Profile profile, String commentText);
}
