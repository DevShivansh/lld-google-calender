package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.enums.Meeting;

public class Calender {

	private Map<LocalDate, List<Meeting>> calender;

	private User u;

	public Calender(User u) {
		this.u = u;
	}

	public void init() {
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.addAll(u.getMeetings());
		meetings.addAll(u.getInvites());
		calender = meetings.stream().collect(Collectors.groupingBy(m -> m.getMeetingTime().toLocalDate()));
	}

	public Map<LocalDate, List<Meeting>> getCalender() {
		return calender;
	}
}
