package com.app.studentServices;

import java.util.List;
import java.util.Optional;

import com.app.entities.Students;

public interface StudentService {

	List<Students> getAllStudents();

	Students newStudent(Students stud);

	boolean DeleteStudentById(Long id);

	List<Students> SortAllStudents();

	List<Students> searchAllStud(String email);

	Optional<Students> searchStudById(Long id);

//	Students updateStud(Students updatedStud);

	Students updtStudent(Students stud);

	

}
