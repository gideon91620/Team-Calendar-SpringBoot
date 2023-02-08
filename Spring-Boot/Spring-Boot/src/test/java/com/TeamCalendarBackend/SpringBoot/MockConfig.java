package com.TeamCalendarBackend.SpringBoot;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.TeamCalendarBackend.SpringBoot.repository.EventRepository;

@TestConfiguration
public class MockConfig {
	
	
	@Bean
	@Primary
	public EventRepository eventRepository() {
		return Mockito.mock(EventRepository.class); 
	}

}
