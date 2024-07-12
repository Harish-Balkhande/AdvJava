package com.app.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.lang.NonNull;

@Entity
@Table
public class Railway {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(length = 20)
	private String name;
	
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private Categoty cat;
	
	@Past(message = "Start time can't be after end time")
	private LocalTime start_time;
	
	private LocalTime end_time;
	
	private String source;
	
	private String destination;
	
	private String stationCode;
	
	private double distance;
	
	private String frequency;
	
	
	public Railway() {}
	
	public Railway(Long id, String name, Categoty cat, LocalTime start_time, LocalTime end_time, String source,
			String destination, String stationCode, double distance, String frequency) {		this.id = id;
		this.name = name;
		this.cat = cat;
		this.start_time = start_time;
		this.end_time = end_time;
		this.source = source;
		this.destination = destination;
		this.stationCode = stationCode;
		this.distance = distance;
		this.frequency = frequency;
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

	public Categoty getCat() {
		return cat;
	}

	public void setCat(Categoty cat) {
		this.cat = cat;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}

	public LocalTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Railway [id=" + id + ", name=" + name + ", cat=" + cat + ", start_time=" + start_time + ", end_time="
				+ end_time + ", source=" + source + ", destination=" + destination + ", stationCode=" + stationCode
				+ ", distance=" + distance + ", frequency=" + frequency + "]";
	}
	
	
	
	

}
