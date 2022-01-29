package com.zubentsov.springboot.cruddemo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubentsov.springboot.cruddemo.entity.Employee;
import com.zubentsov.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		employees = employeeService.findAll();
		return employees;
	}

	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {

		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Can't find employee with id = " + employeeId);
		}

		return employee;
	}

	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {

		// set employee id to 0, if field id is not empty,
		// for control what we save employee, not update
		employee.setId(0);

		employeeService.saveOrUpdate(employee);

		return employee;
	}

	@PutMapping("/employees")
	public Employee udpate(@RequestBody Employee employee) {

	    employeeService.saveOrUpdate(employee);

		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {

		Employee employeeFromService = employeeService.findById(employeeId);
		if (employeeFromService == null) {
			throw new EmployeeNotFoundException("Can't find employee with id = " + employeeId);
		}

		employeeService.delete(employeeId);

		return "Successufully delete employee with id = " + employeeId;
	}

	@ExceptionHandler
	private ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {
		
		EmployeeErrorResponse error = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
				exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	private ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
		
		EmployeeErrorResponse error = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
