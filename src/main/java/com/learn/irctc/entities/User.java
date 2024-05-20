package com.learn.irctc.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ExcludeDefaultListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * 
 */
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "userid")
	private String userId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "confirmpassword")
	private String confirmPassword;

	@Column(name = "hashpassword")
	private String hashPassword;

	@Column(name = "authtimestmp")
	private LocalDateTime dataTime;

	@Transient
	private List<Ticket> ticketBooked;

	public User(String userId, String username, String password, String confirmPassword, String hashPassword,
			LocalDateTime dataTime, List<Ticket> ticketBooked) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.hashPassword = hashPassword;
		this.dataTime = dataTime;
		this.ticketBooked = ticketBooked;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public LocalDateTime getDataTime() {
		return dataTime;
	}

	public void setDataTime(LocalDateTime dataTime) {
		this.dataTime = dataTime;
	}

	public List<Ticket> getTicketBooked() {
		return ticketBooked;
	}

	public void setTicketBooked(List<Ticket> ticketBooked) {
		this.ticketBooked = ticketBooked;
	}

}
