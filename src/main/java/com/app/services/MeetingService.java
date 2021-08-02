package com.app.services;

import com.app.dto.CreateMeetingRequest;
import com.app.enums.Meeting;

public interface MeetingService {

	public Meeting createMeeting(CreateMeetingRequest request);
}
