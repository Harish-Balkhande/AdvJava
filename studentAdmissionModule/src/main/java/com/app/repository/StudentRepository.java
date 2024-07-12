package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Students;

public interface StudentRepository extends JpaRepository<Students, Long> {
	List<Students> findByEmail(String email);
}
