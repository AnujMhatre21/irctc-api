package com.learn.irctc.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.irctc.Repo.TrainRepository;
import com.learn.irctc.entities.Train;

@RestController
@RequestMapping("v1/train")
public class TrainController {
	@Autowired
	TrainRepository repository;

	@GetMapping("/addTrain")
	public ResponseEntity<List<String>> addTrain(String trainid) {

		Train train = new Train();

		List<String> stationList = new LinkedList<>();

		train.setTrainNo("#11159");
		train.setTrainName("Vande Bharat Express");
		train.setSource("C Shivaji Mah T (CSMT)");
		train.setDestination("SAINAGAR SHIRDI (SNSI)");
		train.setTravelTime("06:30 Hrs");

		stationList.add("CST");
		stationList.add("Thane (TNA)");
		stationList.add("Nasik Road (NK)");
		stationList.add("Sainagar Shirdi (SNSI)");

		List<List<String>> availableSeats = new ArrayList<>();

		availableSeats.add(new ArrayList<>());
		availableSeats.add(new ArrayList<>());
		availableSeats.add(new ArrayList<>());

		availableSeats.get(0).add("A1");
		availableSeats.get(0).add("A2");
		availableSeats.get(0).add("A3");

		availableSeats.get(1).add("B1");
		availableSeats.get(1).add("B2");
		availableSeats.get(1).add("B3");

		availableSeats.get(2).add("C1");
		availableSeats.get(2).add("C2");
		availableSeats.get(2).add("C3");
		train.setSeats(availableSeats);
		train.setAllStations(stationList);
		repository.save(train);

		return ResponseEntity.ok().body(stationList);
	}

	@GetMapping("/getDetails")
	public ResponseEntity<List<Train>> getTrain(String trainid) {
		List<Train> all = repository.findAll();
		return ResponseEntity.ok().body(all);
	}

	@GetMapping("/bookTicket")
	public ResponseEntity<List<Train>> bookTicket(String Source, String destination) {

		List<Train> fetchedSourceAndDestination = repository.findBySourceContainingAndDestinationContaining(Source,
				destination);

		String finalSource = "";
		String finalDestination = "";
		for (Train train : fetchedSourceAndDestination) {
			finalSource = train.getSource();
			finalDestination = train.getDestination();
		}

		List<Train> bySourceAndDestination = repository.findBySourceAndDestination(finalSource, finalDestination);
		return ResponseEntity.ok().body(bySourceAndDestination);
	}
}
