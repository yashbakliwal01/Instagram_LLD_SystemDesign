package com.in.interfaces;

import java.util.List;

import com.in.dto.FollowRequest;
import com.in.dto.Profile;

public interface FollowRequestService {
	void createFollowRequest(Profile sender, Profile receiver) throws Exception;
	
	List<FollowRequest> fetchAllRequest(Profile profile);
	
	void acceptFollowRequest(FollowRequest followRequest);
	void rejectFollowRequest(FollowRequest followRequest);
}
