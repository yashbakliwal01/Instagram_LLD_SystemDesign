package com.in.followRequestState;

import com.in.dto.FollowRequest;
import com.in.interfaces.NotificationService;

public abstract class State {
	
	protected NotificationService notificationService;
	
	public State(NotificationService notificationService) {
		super();
		this.notificationService = notificationService;
	}



	public abstract void notifyUser(FollowRequest followRequest);
	
}
