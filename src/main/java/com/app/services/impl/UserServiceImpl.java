package com.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.entities.Calender;
import com.app.entities.MeetingNotification;
import com.app.entities.Notification;
import com.app.entities.User;
import com.app.enums.Meeting;
import com.app.exceptions.AccessDenied;
import com.app.exceptions.ResourceNotFound;
import com.app.repositories.UserRepository;
import com.app.services.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Override
	public void updateUsersRequiredInMeeting(Meeting m) {
		
		User organizer = userRepository.get(m.getOrganizer().getUserID());
		organizer.addMeeting(m);
		
		m.getParticipants().forEach( p -> {
			User participant = userRepository.get(p.getUser().getUserID());
			participant.addInvite(m);
		});
		
	}
	
	
	
	@Override
	public void notifyMeetingInvite(Meeting m) {
		List<User> usersToNotify = new ArrayList<User>();
		User organizer = userRepository.get(m.getOrganizer().getUserID());
		usersToNotify.add(organizer);
		
		m.getParticipants().forEach( p -> {
			User participant = userRepository.get(p.getUser().getUserID());
			usersToNotify.add(participant);
		});
		
		Notification n = new MeetingNotification(m);
		usersToNotify.forEach( u -> u.addNotification(n));
	}



	@Override
	public Calender viewCalenderForUser(Long requestingUserID, Long requestedUserID) {
		if(!userRepository.containsKey(requestingUserID))
			throw new ResourceNotFound("requestingUser not found");
		
		if(!userRepository.containsKey(requestedUserID))
			throw new ResourceNotFound("requestedUser not found");
		
		User requestingUser = userRepository.get(requestingUserID);
		User requestedUser = userRepository.get(requestedUserID);
		
		if(!requestedUser.isViewCalenderAccessable(requestingUser))
			throw new AccessDenied();
		return requestedUser.getCalender(requestingUser);
	}

}
