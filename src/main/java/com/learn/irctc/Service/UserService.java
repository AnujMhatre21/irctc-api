package com.learn.irctc.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.learn.irctc.entities.User;

public interface UserService {

	User createUser(User user);

	User getUser(String userName);

	List<User> getAllUsers();
	
	ResponseEntity<String> deleteUser(String username);

}
