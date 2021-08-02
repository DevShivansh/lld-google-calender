package com.app.queue;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.app.enums.Meeting;
import com.app.enums.NotificationType;
import com.app.services.NotificationService;

public class MeetingReminderQueue implements Runnable{

	private NotificationService notificationService;
	
	private PriorityQueue<Meeting> futureMeetings = new PriorityQueue<Meeting>();
	
	private ExecutorService service = Executors.newSingleThreadExecutor();
	
	public MeetingReminderQueue(NotificationService notificationService) {
		super();
		this.notificationService = notificationService;
		init();
	}

	private void init() {
		service.execute(this);
		
	}

	public void addNewMeeting(Meeting m) {
		futureMeetings.add(m);
		service.notify();
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
				long waitTime = millis - System.currentTimeMillis();
				try {
					service.wait(waitTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}

}
