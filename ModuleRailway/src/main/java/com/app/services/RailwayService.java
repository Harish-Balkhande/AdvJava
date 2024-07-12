package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.entities.Railway;

public interface RailwayService {

	List<Railway> getAllRailways();

	Railway addTrain(Railway rail);

	Railway updtTrain(Railway rail);

	boolean delRailway(Long id);

	List<Railway> sortTrain();

	Optional<Railway> findById(Long id);

	List<Railway> findByName(String name);

	
	
	
}
