package com.app.handler;

import com.app.enums.Meeting;
import com.app.enums.NotificationType;
import com.app.factory.NotificationHandlerFactory;
import com.app.factory.NotificationHandlerRegistrar;
import com.app.queue.MeetingReminderQueue;

public class ReminderHandler implements NotificationHandler {

	private MeetingReminderQueue queue;
	
	public ReminderHandler(MeetingReminderQueue queue) {
		super();
		this.queue = queue;
		((NotificationHandlerRegistrar) NotificationHandlerFactory.INSTANCE)
		.register(NotificationType.REMINDER, this);
	}

	@Override
	public void handle(Object... args) {
		Meeting m = (Meeting) args[0];
		queue.addNewMeeting(m);
		
	}

}
