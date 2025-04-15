package com.in.followRequestState;

import com.in.dto.FollowRequest;
import com.in.service.EmailNotificationServiceImpl;

public class DeclinedState extends State{

	public static DeclinedState declinedState = new DeclinedState();
	
	public static DeclinedState getInstance() {
		if(declinedState==null) {
			declinedState = new DeclinedState();
		}
		return declinedState;
	}
	
	private DeclinedState() {
		super(new EmailNotificationServiceImpl());
	}

	@Override
	public void notifyUser(FollowRequest followRequest) {
		notificationService.sendNotification("Your follow request is not accepted, Please stay away!", followRequest.getSender());
	}

}
