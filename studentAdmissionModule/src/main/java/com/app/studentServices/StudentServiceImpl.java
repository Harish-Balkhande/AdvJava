package com.app.studentServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.courseRepositoy.CourseRepository;
import com.app.entities.Course;
import com.app.entities.Students;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	private StudentRepository studRepo;
	private CourseRepository courseRepo;
//	private ModelMapper moddelMapper;

	@Autowired
	public StudentServiceImpl(StudentRepository studRepo, CourseRepository courseRepo) {
		this.studRepo = studRepo;
		this.courseRepo = courseRepo;
//		this.moddelMapper=moddelMapper;
	}

	@Override
	public List<Students> getAllStudents() {
		return studRepo.findAll();
	}

	@Override
	public Students newStudent(Students stud) {
		//retrive the details of course(object) to store into course table
		Course newCourse = stud.getCourseID();
		if (newCourse != null) {
			//save course details to course table 
			courseRepo.save(newCourse);
			//set course reference as foreign key to course table
			stud.setCourseID(newCourse);
		}
		return studRepo.save(stud);
	}

	@Override
	public boolean DeleteStudentById(Long id) {	
		try {
			studRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Students> SortAllStudents() {		
		return studRepo.findAll(Sort.by(Sort.Direction.ASC, "email"));
	}

	@Override
	public List<Students> searchAllStud(String email) {		
		return studRepo.findByEmail(email);
	}

	@Override
	public Optional<Students> searchStudById(Long id) {		
		return studRepo.findById(id);
	}
	
	@Override
	public Students updtStudent(Students stud) {
		Course crs = stud.getCourseID();
		if(crs != null) {
			courseRepo.save(crs);
			stud.setCourseID(crs);
		}
		return studRepo.save(stud);
	}

//	@Override
//	public Students updateStud(Students updatedStud) {
//		Optional<Students> optionalStudent = studRepo.findById(updatedStud.getStud_id());
//
//		return optionalStudent.map(student -> {
//			student.setFirstname(updatedStud.getFirstname());
//			student.setLastname(updatedStud.getLastname());
//			student.setEmail(updatedStud.getEmail());
//			student.setScore(updatedStud.getScore());
//
//			// Assuming updatedStud.getCourseID() returns a Course object
//			Course updatedCourse = updatedStud.getCourseID();
//			System.out.println("=============================");
//			System.out.println("student : " + updatedStud);
//			System.out.println("=============================");
//			if (updatedCourse != null) {
//				// Retrieve the existing Course entity from the database
//				Long courseId = updatedCourse.getCourse_id();
//				System.out.println("=============================");
//				System.out.println("existingCourse : " + courseId);
//				System.out.println("=============================");
//				Course existingCourse = courseRepo.findById(courseId).orElseThrow(
//						() -> new RuntimeException("Course not found with id " + updatedCourse.getCourse_id()));
//
//				System.out.println("=============================");
//				System.out.println("existingCourse : " + existingCourse);
//				System.out.println("=============================");
//				// Set the Course to the student
//				student.setCourseID(existingCourse);
//			} else {
//				// If updatedCourse is null, optionally clear the association if necessary
//				student.setCourseID(null); // For example, clear the course association
//			}
//
//			return studRepo.save(student);
//		}).orElseThrow(() -> new RuntimeException("Student not found with id " + updatedStud.getCourseID()));
//	}

	
	

}
