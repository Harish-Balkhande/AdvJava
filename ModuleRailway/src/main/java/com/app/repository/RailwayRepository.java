package com.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Railway;

@Transactional
public interface RailwayRepository extends JpaRepository<Railway, Long> {

	List<Railway> findTrainByName(String name);

	

}
