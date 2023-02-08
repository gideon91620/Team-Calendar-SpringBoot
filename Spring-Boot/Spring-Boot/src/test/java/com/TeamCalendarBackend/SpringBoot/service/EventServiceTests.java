package com.TeamCalendarBackend.SpringBoot.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.anyLong;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.TeamCalendarBackend.SpringBoot.MockConfig;
import com.TeamCalendarBackend.SpringBoot.dto.EventDto;
import com.TeamCalendarBackend.SpringBoot.model.Event;
import com.TeamCalendarBackend.SpringBoot.repository.EventRepository;
import com.TeamCalenderBackend.Exception.EntityNotFoundException;

@ActiveProfiles("test")
@SpringBootTest(classes = {EventService.class, EventServiceImpl.class, MockConfig.class})
public class EventServiceTests extends AbstractTestNGSpringContextTests{
	
	
	@Mock
	EventRepository eventRepo;
	
	@InjectMocks
	EventServiceImpl eventService;
	
	private Event event = null;
	
	
	@BeforeClass
	public void setup() {
	    MockitoAnnotations.openMocks(this);
			
    event = new Event();
		
		event.setName("test");
		event.setType("practice");
		event.setLocation("test"); 
		event.setDate("test");
		event.setTime("test");
		event.setReason("test");
		
	}
	
	@Test
	public void shouldFindAllEvents() {
		
		Event event1 = new Event();
		
		event1.setId(1L);
		event1.setName("test");
		event1.setType("practice");
		event1.setLocation("test");
		event1.setDate("test");
		event1.setTime("test");
		event1.setReason("test");
		
		Event event2 = new Event();
		
		event2.setId(2L);
		event2.setName("test2");
		event2.setType("game");
		event2.setLocation("test2");
		event2.setDate("test2");
		event2.setTime("test2");
		event2.setReason("test2");
		
		List<Event> events = new ArrayList<>();
		events.add(event1);
		events.add(event2);
		
		
		when(eventRepo.findAll()).thenReturn(events);
		
		List<Event> result = eventService.getAllEvents();
		
		assertEquals(result, events);
		
		verify(eventRepo).findAll();
		 
	}
	
	@Test
	public void shouldFindEventById() throws Exception {

		
		when(eventRepo.findById(anyLong())).thenReturn(Optional.of(event));
		
		Event result = eventService.getEvent(1L);
		
		assertEquals(result, event);
		assertNotNull(result);
	}
	
	
	@Test
	public void shouldCreateEvent() {
		
		
		EventDto eventdto = new EventDto(); 
		
		eventdto.setName("test");
		eventdto.setType("practice");
		eventdto.setLocation("test");
		eventdto.setDate("test");
		eventdto.setTime("test");
		eventdto.setReason("test");   
		 
		
		
		Mockito.when(eventRepo.save(any(Event.class))).thenReturn(event);
		Event result = eventService.addEvent(eventdto); 
		verify(eventRepo, atMost(2)).save(any(Event.class));
		
		
		assertEquals(result, event);
		
	}
	
	
	
	@Test
	public void shouldUpdateEvent() throws Exception {
		
		
		
		EventDto eventdto = new EventDto(); 
		
		eventdto.setName("test");
		eventdto.setType("practice");
		eventdto.setLocation("test");
		eventdto.setDate("test");
		eventdto.setTime("test");
		eventdto.setReason("test");
		
		Event eventupdated = new Event();
		
		eventupdated.setId(1L);
		eventupdated.setName("testnew1");
		eventupdated.setType("practice");
		eventupdated.setLocation("testnew1");
		eventupdated.setDate("testnew1");
		eventupdated.setTime("testnew1");
		eventupdated.setReason("testnew1");
		

		
		when(eventRepo.findById(anyLong())).thenReturn(Optional.of(event));
		when(eventRepo.save(any(Event.class))).thenReturn(eventupdated);
		Event result = eventService.updateEvent(1L, eventdto);
		verify(eventRepo, atMost(2)).save(any(Event.class)); 

		
		assertEquals(result.getId(), 1);
		assertEquals(result.getName(), "testnew1");
		
	}
	 
	
	@Test
	public void ShouldDeleteUser() throws Exception {

		
		when(eventRepo.findById(1L)).thenReturn(Optional.of(event));
	
		eventService.deleteEvent(1L);
		
		verify(eventRepo).deleteById(1L);
		
		
	} 
	
	
	
									/* NEGATIVE TESTS */
	
	@Test(expectedExceptions = EntityNotFoundException.class, expectedExceptionsMessageRegExp = "Event not found.") 
	public void cannotFindEventById() {
		
		when(eventRepo.findById(5L)).thenReturn(Optional.empty());
		
		
		eventService.getEvent(5L);
		
		verify(eventRepo).findById(5L); 
	}
	
	@Test(expectedExceptions = EntityNotFoundException.class, expectedExceptionsMessageRegExp = "Event not found.")
	public void cannotUpdateEvent() {
		
EventDto eventdto = new EventDto(); 
		
		eventdto.setName("test");
		eventdto.setType("practice");
		eventdto.setLocation("test");
		eventdto.setDate("test");
		eventdto.setTime("test");
		eventdto.setReason("test");
		
		when(eventRepo.findById(5L)).thenReturn(Optional.empty());
		
		eventService.updateEvent(5L, eventdto);
		
		verify(eventRepo).findById(5L);  

		
	
		
	}
	
	@Test(expectedExceptions = EntityNotFoundException.class, expectedExceptionsMessageRegExp = "Event not found.")
	public void cannotDeleteEvent() {
		
when(eventRepo.findById(5L)).thenReturn(Optional.empty());
		
		eventService.deleteEvent(5L);
		
		verify(eventRepo).findById(5L);  

		
	}

}
