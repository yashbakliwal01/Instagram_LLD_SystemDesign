package com.in.followRequestState;

import com.in.dto.FollowRequest;
import com.in.service.EmailNotificationServiceImpl;

public class HoldState extends State{

	
	public static HoldState holdState = new HoldState();
	
	public static HoldState getInstance() {
		if(holdState==null) {
			holdState = new HoldState();
		}
		return holdState;
	}
	
	private HoldState() {
		super(new EmailNotificationServiceImpl());
	}

	@Override
	public void notifyUser(FollowRequest followRequest) {
		notificationService.sendNotification("You have got friend request: ", followRequest.getReceiver());
	}

}
