package com.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.app.dto.CreateMeetingRequest;
import com.app.entities.MeetingMember;
import com.app.entities.Participant;
import com.app.entities.User;
import com.app.enums.InviteResponse;
import com.app.enums.Meeting;
import com.app.enums.NotificationType;
import com.app.exceptions.AccessDenied;
import com.app.exceptions.ResourceNotFound;
import com.app.repositories.MeetingRepository;
import com.app.repositories.UserRepository;
import com.app.services.MeetingService;
import com.app.services.NotificationService;
import com.app.services.UserService;

public class MeetingServiceImpl implements MeetingService{

	private UserRepository userRepository;
	
	private MeetingRepository meetingRepository;
	
	private NotificationService notificationService;
	
	private UserService userService;
	
	
	
	public MeetingServiceImpl(UserRepository userRepository, MeetingRepository meetingRepository,
			NotificationService notificationService, UserService userService) {
		super();
		this.userRepository = userRepository;
		this.meetingRepository = meetingRepository;
		this.notificationService = notificationService;
		this.userService = userService;
	}

	@Override
	public Meeting createMeeting(CreateMeetingRequest request) {
		User organizer = userRepository.get(request.getOrganizerID());
		if(organizer == null)
			throw new ResourceNotFound("No organizer user found with ID");
		
		if(!organizer.isOrganizationMemeber())
			throw new AccessDenied();
		
		List<Participant> participants = fetchParticipants(request.getParticipants()); 
		

		Meeting m = new Meeting(organizer, request.getAgenda(), request.getDesc(), participants, request.getMeetingLocation() );

		meetingRepository.put(m.getMeetingID(), m);
		
		userService.updateUsersRequiredInMeeting(m);
		
		notificationService.notify(NotificationType.MEETING_INVITE, m);
		notificationService.notify(NotificationType.REMINDER, m);
		
		return m;
	}

	private List<Participant> fetchParticipants(List<Long> participants) {
		
		List<User> requiredUsers = participants.stream().map(id -> userRepository.getOrDefault(id, null))
				.filter(u -> u != null).collect(Collectors.toList());
		
		if(requiredUsers.size() != participants.size())
			throw new ResourceNotFound("Meeting participants not registered with app");
		
		return requiredUsers.stream().map( u -> new Participant(u, InviteResponse.UNREAD))
		.collect(Collectors.toList());
		
	}
	
	public void reminder(Meeting m) {
		
	}

}
