package com.TeamCalendarBackend.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TeamCalendarBackend.SpringBoot.dto.EventDto;
import com.TeamCalendarBackend.SpringBoot.model.Event;
import com.TeamCalendarBackend.SpringBoot.service.EventService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping
	public ResponseEntity<List<Event>> events(){
		return new ResponseEntity<List<Event>>(eventService.getAllEvents(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") Long id) {
		System.out.println("event id====================="+ id);
		Event event = eventService.getEvent(id);
		return new ResponseEntity<Event>(event, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Void> events(@RequestBody EventDto event) {
		eventService.addEvent(event);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") Long id, @RequestBody EventDto dto) {
		eventService.updateEvent(id, dto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED); 
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("id") Long id) {
		eventService.deleteEvent(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
