package com.app.entities;

import java.time.LocalDateTime;

import com.app.enums.NotificationStatus;
import com.app.enums.NotificationType;

public abstract class Notification {

	private String notificationID;
	
	private NotificationStatus notificationStatus;
	
	private LocalDateTime notificationTime;
	
	public abstract NotificationType getNotificationType();
	
	public abstract String message();

	public Notification(String notificationID) {
		super();
		this.notificationID = notificationID;
		notificationTime = LocalDateTime.now();
		notificationStatus = NotificationStatus.PENDING;
		
	}

	public String getNotificationID() {
		return notificationID;
	}

	public NotificationStatus getNotificationStatus() {
		return notificationStatus;
	}

	public LocalDateTime getNotificationTime() {
		return notificationTime;
	}
	
	
	
	
}
