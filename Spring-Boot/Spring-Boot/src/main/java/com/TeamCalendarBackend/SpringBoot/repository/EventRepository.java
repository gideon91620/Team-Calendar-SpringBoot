package com.TeamCalendarBackend.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TeamCalendarBackend.SpringBoot.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
