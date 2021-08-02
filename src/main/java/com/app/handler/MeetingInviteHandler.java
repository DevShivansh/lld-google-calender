package com.app.handler;

import com.app.enums.Meeting;
import com.app.enums.NotificationType;
import com.app.factory.NotificationHandlerFactory;
import com.app.factory.NotificationHandlerRegistrar;
import com.app.services.UserService;

public class MeetingInviteHandler implements NotificationHandler {

	private UserService userService;
	
	public MeetingInviteHandler(UserService userService) {
		super();
		this.userService = userService;
		((NotificationHandlerRegistrar) NotificationHandlerFactory.INSTANCE)
		.register(NotificationType.MEETING_INVITE, this);
	}



	@Override
	public void handle(Object... args) {
		Meeting m = (Meeting) args[0];
		userService.notifyMeetingInvite(m);
		
	}

}
