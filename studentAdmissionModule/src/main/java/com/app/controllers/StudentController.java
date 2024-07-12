			package com.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Students;
import com.app.studentServices.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	private StudentService studService;
	
	@Autowired
	public StudentController(StudentService service) {
		this.studService = service;
	}
	
	@GetMapping("/get")
	public List<Students> getAll(){
		return studService.getAllStudents();
	}
	
	@PostMapping("/insert")
	public Students AddNewStudent(@RequestBody Students stud) {
		return studService.newStudent(stud);
	}
	
	@PutMapping("/insertUpdt")
	public Students updttudent(@RequestBody Students stud) {
		return studService.updtStudent(stud);
	}
	
	@DeleteMapping("delete/{id}")
	public boolean DeleteStudent(@PathVariable Long id) {
		return studService.DeleteStudentById(id);
	}
	
	@GetMapping("/sort")
	public List<Students> sortStudent(){
		return studService.SortAllStudents();
	}
	
	@GetMapping("search/{email}")
	public List<Students> searchStudent(@PathVariable String email){
		return studService.searchAllStud(email);
	}
	 
	@GetMapping("searchById/{id}")
	public Optional<Students> searchById(@PathVariable Long id){
		return studService.searchStudById(id);
	}
	
	
	
	
}

