package com.in.service;

import com.in.dto.Notification;
import com.in.dto.Profile;
import com.in.interfaces.NotificationService;

public class SMSNotificationServiceImpl implements NotificationService{

	@Override
	public void sendNotification(String description, Profile profile) {
		Notification notification = new Notification(description);
        profile.getNotifications().add(notification);
        System.out.println("SMS sent to [" + profile.getEmail() + "]: " + description);
	}

}
