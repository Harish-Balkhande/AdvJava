package com.app.courseRepositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
