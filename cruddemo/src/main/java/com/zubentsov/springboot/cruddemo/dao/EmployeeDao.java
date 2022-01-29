package com.zubentsov.springboot.cruddemo.dao;

import java.util.List;

import com.zubentsov.springboot.cruddemo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id); 
	
	public void saveOrUpdate(Employee employeeId);
	
	public void delete(int id);
		
}
