package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import com.app.entities.permission.ViewPermission;
import com.app.enums.Meeting;
import com.app.enums.UserType;
import com.app.exceptions.AccessDenied;

public abstract class User implements MeetingMember{

	private static Long globalID = 1l;
	
	private Long userID;
	
	private String userName;
	
	private String emailID;
	
	private List<Meeting> meetings;
	
	private List<Meeting> invites;
	
	private List<Notification> notifications;
	
	private ViewPermission viewPermission;
	
	
	public User(String userName, String emailID, ViewPermission viewPermission) {
		super();
		this.userID = globalID++;
		this.userName = userName;
		this.emailID = emailID;
		meetings = new ArrayList<Meeting>();
		invites = new ArrayList<Meeting>();
		notifications = new ArrayList<Notification>();
		this.viewPermission = viewPermission;
	}

	public abstract UserType getUserType();
	
	public boolean isViewCalenderAccessable(User otherUser) {
		return viewPermission.hasPermission(otherUser);
	}

	@Override
	public Long getUserID() {
		return userID;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public String getEmailID() {
		return emailID;
	}

	
	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void addMeeting(Meeting meeting) {
		this.meetings.add(meeting);
	}

	public List<Meeting> getInvites() {
		return invites;
	}

	public void addInvite(Meeting invite) {
		this.invites.add(invite);
	}

	public boolean isOrganizationMemeber() {
		// TODO Auto-generated method stub
		return getUserType() == UserType.MEMBER;
	}

	public void addNotification(Notification n) {
		notifications.add(n);
	}
	
	public Calender getCalender(User requestingUser) {
		if(!isViewCalenderAccessable(requestingUser))
			throw new AccessDenied();
		Calender c = new Calender(this);
		return c;
	}
	
}
