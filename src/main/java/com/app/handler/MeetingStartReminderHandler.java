package com.app.handler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.PriorityQueue;

import com.app.enums.Meeting;
import com.app.enums.NotificationType;
import com.app.services.NotificationService;

public class MeetingStartReminderHandler implements Runnable{

	private NotificationService notificationService;
	
	private PriorityQueue<Meeting> futureMeetings = new PriorityQueue<Meeting>();
	
	
	public void addNewMeeting(Meeting m) {
		futureMeetings.add(m);
		this.notify();
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			Meeting m = futureMeetings.poll();
			LocalDateTime meetingTime = m.getMeetingTime();
			if(meetingTime.minusMinutes(10).isBefore(LocalDateTime.now())) {
				notificationService.notify(NotificationType.MEETING_INVITE, m);
				
			}else {
				futureMeetings.add(m);
				ZonedDateTime zdt = m.getMeetingTime().atZone(ZoneId.of("Asia/Kolkata"));
				long millis = zdt.toInstant().toEpochMilli();
				long waitTime = millis = System.currentTimeMillis();
				try {
					this.wait(waitTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}

}
