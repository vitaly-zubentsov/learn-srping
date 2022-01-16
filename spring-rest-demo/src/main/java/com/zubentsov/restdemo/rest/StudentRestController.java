package com.zubentsov.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubentsov.restdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getListOfStudents() {
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Ivan", "Ivanov"));
		students.add(new Student("Gleb", "Patrushev"));
		students.add(new Student("Maria", "Ivanovna"));
		
		return students;
	}
}
