package com.zubentsov.springboot.thymeleafdemo.service;

import java.util.List;

import com.zubentsov.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int employeeId);
	void saveOrUpdate(Employee employee);
	void delete(int employeeId);

}
