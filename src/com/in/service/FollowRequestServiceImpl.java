package com.in.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import com.in.dto.FollowRequest;
import com.in.dto.Profile;
import com.in.followRequestState.AcceptedState;
import com.in.followRequestState.DeclinedState;
import com.in.interfaces.FollowRequestService;

public class FollowRequestServiceImpl implements FollowRequestService{

	private ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void createFollowRequest(Profile sender, Profile receiver) throws Exception {
		lock.lock();
		try {
			if(checkIfPresent(sender, receiver)) {
				throw new Exception("Follow Request already Present");
			}
			
			FollowRequest followRequest = new FollowRequest(sender, receiver);
			receiver.getFollowRequests().add(followRequest);
			followRequest.sendNotification();
		}finally {
			lock.unlock();
		}
	}

	@Override
	public List<FollowRequest> fetchAllRequest(Profile profile) {
		lock.lock();
		try {
			return new ArrayList<>(profile.getFollowRequests());
		}finally {
			lock.unlock();
		}
	}

	@Override
	public void acceptFollowRequest(FollowRequest followRequest) {
		lock.lock();
		try {
			followRequest.setFollowRequestState(AcceptedState.getInstance());
			followRequest.sendNotification();
			removeFollowRequest(followRequest);
			followRequest.getReceiver().getFollowers().add(followRequest.getSender());
		}finally {
			lock.unlock();
		}
	}

	@Override
	public void rejectFollowRequest(FollowRequest followRequest) {
		lock.lock();
		try {
			followRequest.setFollowRequestState(DeclinedState.getInstance());
			followRequest.sendNotification();
			removeFollowRequest(followRequest);
		}finally {
			lock.unlock();
		}
	}
	
	private boolean checkIfPresent(Profile sender, Profile receiver) {
		List<FollowRequest> followRequests = receiver.getFollowRequests();
		return followRequests.stream()
				.parallel()
				.filter(followRequest->followRequest.getSender().equals(sender))
				.findFirst()
				.isPresent();
	}
	
	private void removeFollowRequest(FollowRequest followRequest) {
		followRequest.getReceiver().getFollowRequests().remove(followRequest);
	}

}
