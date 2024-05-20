package com.learn.irctc.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.servlet.annotation.HttpConstraint;

@Entity
@Table(name = "train")
public class Train {
	@Id
	@Column(name = "trainname")
	private String trainName;

	@Column(name = "trinno")
	private String trainNo;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "departtime")
	private String departTime;

	@Column(name = "arrivaltime")
	private String arrivalTime;

	@Column(name = "traveltime")
	private String travelTime;

	private List<List<String>> seats;

	private List<String> allStations;

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Train(String trainName, String trainNo, String source, String destination, String departTime,
			String arrivalTime, String travelTime, List<List<String>> seats, List<String> allStations) {
		super();
		this.trainName = trainName;
		this.trainNo = trainNo;
		this.source = source;
		this.destination = destination;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.travelTime = travelTime;
		this.seats = seats;
		this.allStations = allStations;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
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

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}

	public List<List<String>> getSeats() {
		return seats;
	}

	public void setSeats(List<List<String>> seats) {
		this.seats = seats;
	}

	public List<String> getAllStations() {
		return allStations;
	}

	public void setAllStations(List<String> allStations) {
		this.allStations = allStations;
	}

}
