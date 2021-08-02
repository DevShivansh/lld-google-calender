package com.app.services;

import com.app.entities.Calender;
import com.app.enums.Meeting;

public interface UserService {

	void updateUsersRequiredInMeeting(Meeting n);

	void notifyMeetingInvite(Meeting m);
	
	Calender viewCalenderForUser(Long requestingUserID, Long requestedUserID);
}
