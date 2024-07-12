package com.app.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.entities.Railway;
import com.app.repository.RailwayRepository;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService {
	private RailwayRepository railRepo;
	
	public RailwayServiceImpl(RailwayRepository railRepo) {
		this.railRepo=railRepo;
	}
	
	
	@Override
	public List<Railway> getAllRailways() {		
		return railRepo.findAll();
	}

	@Override
	public Railway addTrain(Railway rail) {		
		return railRepo.save(rail);
	}

	@Override
	public Railway updtTrain(Railway rail) {
		Optional<Railway> option = railRepo.findById(rail.getId());
		if(option.isPresent()) {
			Railway railway = option.get();
			
			railway.setName(rail.getName());
			railway.setCat(rail.getCat());
			railway.setStart_time(rail.getStart_time());
			railway.setEnd_time(rail.getEnd_time());
			railway.setSource(rail.getSource());
			railway.setDestination(rail.getDestination());
			railway.setStationCode(rail.getStationCode());
			railway.setDistance(rail.getDistance());
			railway.setFrequency(rail.getFrequency());
			
			return railRepo.save(railway);
		}else {
			throw new RuntimeException("Railway not found");
		}
		
	}

	@Override
	public boolean delRailway(Long id) {
		try {
			railRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;			
		}
	}


	@Override
	public List<Railway> sortTrain() {		
		return railRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}


	@Override
	public List<Railway> findByName(String name) {		
		return railRepo.findTrainByName(name) ;
	}


	@Override
	public Optional<Railway> findById(Long id) {
		
		return railRepo.findById(id);
	}
	
	
}
