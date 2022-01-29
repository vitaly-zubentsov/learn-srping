package com.zubentsov.springboot.cruddemo.service;

import java.util.List;

import com.zubentsov.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int employeeId);
	
	void saveOrUpdate(Employee employee);
	
	void delete(int employeeId);

}
