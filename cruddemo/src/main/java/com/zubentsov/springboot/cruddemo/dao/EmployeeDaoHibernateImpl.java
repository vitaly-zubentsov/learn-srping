package com.zubentsov.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubentsov.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	EmployeeDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override

	public List<Employee> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);

		return currentSession.get(Employee.class, id);
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void delete(int employeeId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("delete from Customer where id=:customerId");

		query.setParameter("customerId", employeeId);

		query.executeUpdate();

	}

}
