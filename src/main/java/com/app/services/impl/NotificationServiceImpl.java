package com.app.services.impl;

import org.springframework.scheduling.annotation.Async;

import com.app.enums.NotificationType;
import com.app.exceptions.InvalidOperation;
import com.app.handler.MeetingInviteHandler;
import com.app.handler.MeetingStartReminderHandler;
import com.app.handler.NotificationHandler;
import com.app.handler.ReminderHandler;
import com.app.services.NotificationService;
import com.app.services.UserService;

public class NotificationServiceImpl implements NotificationService{

	private UserService userService;
	
	private MeetingStartReminderHandler meetingStartReminderHandler;
	
	@Override
	@Async
	public void notify(NotificationType type, Object... args) {
		
		NotificationHandler m = null;
		
		switch (type) {
		case MEETING_INVITE:
			m = new MeetingInviteHandler(userService, meetingStartReminderHandler);
			break;
		case REMINDER:
			m = new ReminderHandler();
			
		default:
			throw new InvalidOperation("Notification publish type not registered");
		}
		
		m.handle(args);
		
	}

}
