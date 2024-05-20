package com.learn.irctc.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.irctc.entities.Train;

public interface TrainRepository extends JpaRepository<Train, String> {

	public List<Train> findBySourceAndDestination(String source, String destination);
	
	public List<Train> findBySourceLike(String source);
	
	public List<Train> findByDestinationLike(String destination);
	
	public List<Train> findBySourceContainingAndDestinationContaining(String source, String destination);
}
