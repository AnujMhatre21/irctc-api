package com.learn.irctc.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learn.irctc.Repo.TrainRepository;
import com.learn.irctc.Service.TrainService;
import com.learn.irctc.entities.Train;

@Service
public class TraiImpl implements TrainService {

	@Autowired
	TrainRepository repository;
	
	@Override
	public List<String> getAllStation(String trainid) {
		
		
		return null;
	}

	

}
