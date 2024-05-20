package com.learn.irctc.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.irctc.Service.UserService;
import com.learn.irctc.entities.User;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/addnewusers")
	public ResponseEntity<String> createUser(@RequestParam String name, @RequestParam String password,
			@RequestParam String confirmPassword) {
		System.out.println("Inside create user");

		int length = password.length();
		if (length < 6) {
			return (ResponseEntity<String>) ResponseEntity.badRequest()
					.body("Password must be of atleaset 6 characters Please enter again.");
		}
		if (password.hashCode() != confirmPassword.hashCode()) {
			return ResponseEntity.badRequest().body("Confirm Password Doesn't Match. Please enter again");
		}

		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setConfirmPassword(confirmPassword);
		user.setDataTime(LocalDateTime.now());

		service.createUser(user);

		return ResponseEntity.ok("New User Created");
	}

	@GetMapping("/getUser/{userName}")
	public ResponseEntity<User> getUser(@RequestParam String userName) {
		User user = service.getUser(userName);
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/allusers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = service.getAllUsers();
		return ResponseEntity.ok().body(allUsers);
	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<String> deleteUser(@RequestParam String username) {
		return service.deleteUser(username);
	}

}
