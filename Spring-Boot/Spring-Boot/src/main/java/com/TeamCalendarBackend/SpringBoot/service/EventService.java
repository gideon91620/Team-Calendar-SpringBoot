package com.TeamCalendarBackend.SpringBoot.service;

import java.util.List;

import com.TeamCalendarBackend.SpringBoot.dto.EventDto;
import com.TeamCalendarBackend.SpringBoot.model.Event;



public interface EventService {

	public List<Event> getAllEvents();
	public Event addEvent(EventDto event);
	public Event getEvent(Long id);
	public Event updateEvent(Long id, EventDto event);
	public Event deleteEvent(Long id);

}
