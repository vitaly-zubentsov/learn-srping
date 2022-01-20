package com.zubentsov.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubentsov.restdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> students;

	// define PostConstruct to load student ... only once

	@PostConstruct
	public void LoadData() {

		students = new ArrayList<>();

		students.add(new Student("Ivan", "Ivanov"));
		students.add(new Student("Gleb", "Patrushev"));
		students.add(new Student("Maria", "Ivanovna"));

	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// check student id against list size
		if ((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("StudenId not found - " + studentId);
		}
		return students.get(studentId);
	}

	// Add exception handler using @ExceprionHandler

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		//Create a student error response
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis()); 
				
		//return response entity
		
		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	//exception handler to catch all exception
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		
		//Create a student error response
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		
		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis()); 
				
		//return response entity
		
		return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
	}
 
}
