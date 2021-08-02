package com.app.enums;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.app.entities.MeetingMember;
import com.app.entities.Participant;

public class Meeting implements Comparable<Meeting> {

	private String meetingID;
	
	private MeetingMember organizer;
	
	private String agenda;
	
	private String desc;
	
	private List<Participant> participants;
	
	private LocalDateTime meetingTime;
	
	private String meetingLocation;
	
	

	public Meeting(MeetingMember organizer, String agenda, String desc, List<Participant> participants,
			String meetingLocation) {
		super();
		meetingID = UUID.randomUUID().toString();
		this.organizer = organizer;
		this.agenda = agenda;
		this.desc = desc;
		this.participants = participants;
		this.meetingLocation = meetingLocation;
		meetingTime = LocalDateTime.now();
	}

	public MeetingMember getOrganizer() {
		return organizer;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public LocalDateTime getMeetingTime() {
		return meetingTime;
	}

	public String getMeetingLocation() {
		return meetingLocation;
	}
	
	public String getAgenda() {
		return agenda;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getMeetingID() {
		return meetingID;
	}

	@Override
	public String toString() {
		return "Meeting [meetingID=" + meetingID + ", organizer=" + organizer + ", agenda=" + agenda + ", desc=" + desc
				+ ", participants=" + participants + ", meetingTime=" + meetingTime + ", meetingLocation="
				+ meetingLocation + "]";
	}

	@Override
	public int compareTo(Meeting o) {
		// TODO Auto-generated method stub
		return this.meetingTime.isBefore(o.meetingTime) ? -1 : 1;
	}

	
	
}
