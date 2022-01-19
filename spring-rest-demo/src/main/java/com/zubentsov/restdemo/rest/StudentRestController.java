package com.zubentsov.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
	
	
	@GetMapping("/students/{studentid}")
	public Student getStudent(@PathVariable int studentid) {
		return students.get(studentid);
	}

}
