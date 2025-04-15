package com.in.followRequestState;

import com.in.dto.FollowRequest;
import com.in.service.SMSNotificationServiceImpl;

public class AcceptedState extends State{

	public static AcceptedState acceptedState = new AcceptedState();
	
	public static AcceptedState getInstance() {
		if(acceptedState==null) {
			acceptedState = new AcceptedState();
		}
		return acceptedState;
	}
	
	private AcceptedState() {
		super(new SMSNotificationServiceImpl());
	}

	@Override
	public void notifyUser(FollowRequest followRequest) {
		notificationService.sendNotification("Your follow request is accepted", followRequest.getSender());
	}

}
