package com.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Railway;
import com.app.services.RailwayService;

@RestController
@RequestMapping("rails")
public class RailwayController {
	private RailwayService railService;

	@Autowired
	public RailwayController(RailwayService railService) {
		this.railService = railService;
	}

	@GetMapping("/get")
	public List<Railway> getRailway() {
		return railService.getAllRailways();
	}

	@PostMapping("/insert")
	public Railway AddNewRailway(@Valid @RequestBody Railway rail) {
		return railService.addTrain(rail);
	}

	@PutMapping("/update")
	public Railway updateRailway(@RequestBody Railway rail) {
		return railService.updtTrain(rail);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteRailway(@PathVariable Long id) {
		return railService.delRailway(id);
	}
	
	@GetMapping("/sort")
	public List<Railway> sortRailway() {
		return railService.sortTrain();
	}
	
	@GetMapping("/getByName/{name}")
	public List<Railway> findRailway(@PathVariable String name) {
		return railService.findByName(name);
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Railway> findTrainById(@PathVariable Long id) {
		return railService.findById(id);
	}
	
	

}
