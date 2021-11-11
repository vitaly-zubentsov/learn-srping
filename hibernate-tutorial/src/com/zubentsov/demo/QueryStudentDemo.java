package com.zubentsov.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// query students
			List<Student> students = session.createQuery("FROM Student").getResultList();

			// display all studenst
			System.out.println("All Students");
			displayStudents(students);

			// Students who have firstName Taco
			students = session.createQuery("FROM Student a WHERE a.firstName='Taco'").getResultList();

			System.out.println("Students who have firstName Taco");
			displayStudents(students);

			// Students who have firstName Taco or lastName Zavodnov
			students = session.createQuery("FROM Student a WHERE a.firstName='Taco' OR a.lastName='Zavodnov'")
					.getResultList();

			System.out.println("Students who have firstName Taco or lastName Zavodnov");
			displayStudents(students);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("\n");
	}

}
