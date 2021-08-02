package com.app.handler;

import com.app.enums.Meeting;
import com.app.services.UserService;

public class MeetingInviteHandler implements NotificationHandler {

	private UserService userService;
	
	private MeetingStartReminderHandler meetingStartReminderHandler;
	
	
	public MeetingInviteHandler(UserService userService, MeetingStartReminderHandler meetingStartReminderHandler) {
		super();
		this.userService = userService;
		this.meetingStartReminderHandler = meetingStartReminderHandler;
	}



	@Override
	public void handle(Object... args) {
		Meeting m = (Meeting) args[0];
		
		userService.notifyMeetingInvite(m);
		meetingStartReminderHandler.addNewMeeting(m);
		
	}

}
