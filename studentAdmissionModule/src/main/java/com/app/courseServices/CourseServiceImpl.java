package com.app.courseServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.courseRepositoy.CourseRepository;
import com.app.entities.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	private CourseRepository courseRepo;
	
	@Autowired
	public CourseServiceImpl(CourseRepository service) {
		this.courseRepo = service;
	}

	@Override
	public Course AddNewCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public Course updateCourse(Course crs) {
		Optional<Course> cr = courseRepo.findById(crs.getCourse_id());
		if(cr != null) {
			Course course = cr.get();
			
			course.setStart_time(crs.getStart_date());
			course.setEnd_date(crs.getEnd_date());
			course.setFees(crs.getFees());
			course.setMin_score(crs.getMin_score());
			
			return courseRepo.save(course);
			
		}else {
            throw new RuntimeException("Railway with id " + crs.getCourse_id() + " not found");
        }
		
	}
	
	
}
