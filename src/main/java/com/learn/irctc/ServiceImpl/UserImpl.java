package com.learn.irctc.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learn.irctc.Exception.UserNotFoundException;
import com.learn.irctc.Exception.globalExceptionHandler;
import com.learn.irctc.Repo.UserRepository;
import com.learn.irctc.Service.UserService;
import com.learn.irctc.entities.User;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User createUser(User user) {

		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		user.setHashPassword("123");
//		user.setTicketBooked("123");

		User savedUser = repository.save(user);
		return savedUser;
	}

	@Override
	public User getUser(String userName) {

		User fetcheduser = repository.findByUsername(userName)
				.orElseThrow(() -> new UserNotFoundException("Enter User Not Found with username : " + userName));

		return fetcheduser;
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<String> deleteUser(String username) {
		User fetchedUser = getUser(username);
		if (fetchedUser != null) {
			repository.deleteById(fetchedUser.getUserId());
			return ResponseEntity.ok(username + " has bee successfully Deleted.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Username is Invalid. Please try again");
		}

	}

}
