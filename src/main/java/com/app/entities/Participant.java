package com.app.entities;

import com.app.enums.InviteResponse;

public class Participant {

	private MeetingMember user;
	
	private InviteResponse response;
	
	public Participant(MeetingMember user, InviteResponse response) {
		super();
		this.user = user;
		this.response = response;
	}

	public MeetingMember getUser() {
		return user;
	}

	public InviteResponse getResponse() {
		return response;
	}
	
	
}
