package com.learn.irctc.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	private String ticketId;

	private String userId;

	private String source;

	private String destination;

	private LocalDate dateOfTravel;

	@Transient
	private Train train;

}
