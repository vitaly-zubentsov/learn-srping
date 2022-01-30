package com.zubentsov.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubentsov.springboot.thymeleafdemo.dao.EmployeeDao;
import com.zubentsov.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao;
	
	@Autowired
	EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		
		return employeeDao.findById(employeeId);
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}

	@Override
	public void delete(int employeeId) {
		employeeDao.delete(employeeId);
	}

}
