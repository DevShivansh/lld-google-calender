package com.app.dto;

import java.util.ArrayList;
import java.util.List;

public class CreateMeetingRequest {

	
	private Long organizerID;
	
	private String agenda;
	
	private String desc;
	
	private List<Long> participants;
	
	private String meetingLocation;

	public CreateMeetingRequest(Long organizerID, String agenda, String desc,
			String meetingLocation) {
		super();
		this.organizerID = organizerID;
		this.agenda = agenda;
		this.desc = desc;
		this.participants = new ArrayList<Long>();
		this.meetingLocation = meetingLocation;
	}
	
	public void addParticipants(Long id) {
		this.participants.add(id);
	}

	public Long getOrganizerID() {
		return organizerID;
	}

	public String getAgenda() {
		return agenda;
	}

	public String getDesc() {
		return desc;
	}

	public List<Long> getParticipants() {
		return participants;
	}

	public String getMeetingLocation() {
		return meetingLocation;
	}
	
	
	
	

}
