package com.TeamCalendarBackend.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String type;
	private String location;
	private String date;
	private String time;
	private String reason;
	
	public Event() {
		super();
	}
	
	
	public Event(String name, String type, String location, String date, String time, String reason) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
		this.date = date;
		this.time = time;
		this.reason = reason;
	}


	public Event(Long id, String name, String type, String location, String date, String time, String reason) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.location = location;
		this.date = date;
		this.time = time;
		this.reason = reason;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", type=" + type + ", location=" + location + ", date=" + date
				+ ", time=" + time + ", reason=" + reason + "]";
	}

	
}
