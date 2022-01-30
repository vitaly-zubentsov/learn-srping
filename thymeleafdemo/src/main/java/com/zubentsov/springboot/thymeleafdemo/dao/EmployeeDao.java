package com.zubentsov.springboot.thymeleafdemo.dao;

import java.util.List;

import com.zubentsov.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();
	Employee findById(int employeeId);
	void saveOrUpdate(Employee employee);
	void delete(int employeeId);
}
