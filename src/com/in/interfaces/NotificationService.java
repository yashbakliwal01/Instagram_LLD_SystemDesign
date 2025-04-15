package com.in.interfaces;

import com.in.dto.Profile;

public interface NotificationService {
	void sendNotification(String description, Profile profile);
}
