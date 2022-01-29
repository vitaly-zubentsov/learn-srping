package com.zubentsov.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zubentsov.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
