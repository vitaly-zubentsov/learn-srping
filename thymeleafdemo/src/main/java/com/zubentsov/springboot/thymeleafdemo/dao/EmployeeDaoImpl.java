package com.zubentsov.springboot.thymeleafdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubentsov.springboot.thymeleafdemo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	@Autowired
	EmployeeDaoImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	@Override
	public List<Employee> findAll() {
		
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {
		
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		
		Employee employeeFromDb = entityManager.merge(employee);
		
		employee.setId(employeeFromDb.getId());
	}

	@Override
	public void delete(int employeeId) {
		
		Query query = entityManager.createQuery("delete from Customer where id=:customerId");

		query.setParameter("customerId", employeeId);

		query.executeUpdate();

	}

}
