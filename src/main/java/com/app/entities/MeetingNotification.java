package com.app.entities;

import java.util.UUID;

import com.app.enums.Meeting;
import com.app.enums.NotificationType;

public class MeetingNotification extends Notification {

	
	private static final NotificationType NOTIFICATION_TYPE = NotificationType.MEETING_INVITE;
	
	private Meeting m;
	
	public MeetingNotification(Meeting m) {
		super(UUID.randomUUID().toString());
		this.m = m;
	}

	@Override
	public NotificationType getNotificationType() {
		// TODO Auto-generated method stub
		return NOTIFICATION_TYPE;
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		return m.toString();
	}

}
