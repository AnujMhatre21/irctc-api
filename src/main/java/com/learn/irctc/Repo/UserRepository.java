package com.learn.irctc.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.irctc.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	public Optional<User> findByUsername(String usename);

//	another approach

//	@Query("SELECT U FROM USER U WHERE U.EMAIL =: email")
//	public User getUserByUserName(@Param("email") String email);

}
