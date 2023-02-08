package com.TeamCalendarBackend.SpringBoot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TeamCalendarBackend.SpringBoot.dto.EventDto;
import com.TeamCalendarBackend.SpringBoot.model.Event;
import com.TeamCalendarBackend.SpringBoot.repository.EventRepository;
import com.TeamCalenderBackend.Exception.EntityNotFoundException;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override 
	public List<Event> getAllEvents() {
		return eventRepository.findAll(); 
	}

	@Override
	public Event addEvent(EventDto dto) {
		Event event =  new Event(dto.getName(), dto.getType(), dto.getLocation(), dto.getDate(),
		 dto.getTime(), dto.getReason()); 
		return eventRepository.save(event);
	}
 
	@Override
	public Event getEvent(Long id){
		return eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found."));

	}

	@Override
	public Event updateEvent(Long id, EventDto dto) {
		Event event = eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found."));
		
		event.setName(dto.getName());
		event.setType(dto.getType());
		event.setLocation(dto.getLocation()); 
		event.setDate(dto.getDate());
		event.setTime(dto.getTime());
		event.setReason(dto.getReason());
		return eventRepository.save(event); 
	}

	@Override
	public Event deleteEvent(Long id){
		
		Event event = eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found."));
		
			eventRepository.deleteById(id);
			return event; 
		 


	}

}
