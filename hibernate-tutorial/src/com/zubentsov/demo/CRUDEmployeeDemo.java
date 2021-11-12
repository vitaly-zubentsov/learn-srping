package com.zubentsov.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Employee;

public class CRUDEmployeeDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate-employee.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			// create list of 10 employees
			List<Employee> employees = new ArrayList<Employee>();
			for (int i = 0; i < 5; i++) {
				employees.add(new Employee("name" + i, "last name " + i, "company " + i));
			}

			// begin session transaction
			session.beginTransaction();

			// save 5 employees to DB
			for (Employee tempEmployee : employees) {
				session.save(tempEmployee);
			}

			// get and print list of employees
			List<Employee> employeesFromDB = session.createQuery("from Employee").getResultList();
			printListOfEmployees(employeesFromDB);

			// get last employee from DB by ID
			System.out.println("get last employee from DB by ID");
			Employee employeeById = session.get(Employee.class,
					employeesFromDB.get(employeesFromDB.size() - 1).getId());
			System.out.println(employeeById);

			// get and print list of employees
			employeesFromDB = session.createQuery("FROM Employee").getResultList();
			printListOfEmployees(employeesFromDB);

			// update last employee
			System.out.println("\nUpdate last employee");
			Employee lastEmployee2 = session.get(Employee.class,
					employeesFromDB.get(employeesFromDB.size() - 1).getId());
			lastEmployee2.setLastName("IZI PIZI");

			// get and print list of employees
			employeesFromDB = session.createQuery("FROM Employee").getResultList();
			printListOfEmployees(employeesFromDB);

			// update employees by query
			
			//query update don't work if not commit
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nUpdate employees by query");
			session.createQuery("UPDATE Employee set company='none'").executeUpdate();

			// get and print list of employees
			employeesFromDB = session.createQuery("FROM Employee").getResultList();
			printListOfEmployees(employeesFromDB);

			// delete last employee
			System.out.println("\nDelete last employee");
			Employee lastEmployee = session.get(Employee.class,
					employeesFromDB.get(employeesFromDB.size() - 1).getId());
			session.remove(lastEmployee);

			// get and print list of employees
			employeesFromDB = session.createQuery("FROM Employee").getResultList();
			printListOfEmployees(employeesFromDB);

			// delete all employees by query
			System.out.println("Delete all employees by query");
			session.createQuery("DELETE FROM Employee").executeUpdate();
			
			// get and print list of employees
						employeesFromDB = session.createQuery("FROM Employee").getResultList();
						printListOfEmployees(employeesFromDB);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

	private static void printListOfEmployees(List<Employee> employees) {
		System.out.println("All employees from DB");
		for (Employee tempEmployee : employees) {
			System.out.println(tempEmployee);
		}
	}

}
