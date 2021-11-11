package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {

			Student tempStudent = new Student("Taco", "Coldonov", "TC@google.com");

			System.out.println("Studen before save in db : " + tempStudent);

			session.beginTransaction();

			session.save(tempStudent);

			session.getTransaction().commit();

			System.out.println("Save student to db");

			System.out.println("Studen after save in db : " + tempStudent);

			// get object from db
			session = factory.getCurrentSession();

			session.beginTransaction();

			Student studdentFromDB = session.get(Student.class, tempStudent.getId());

			session.getTransaction().commit();

			System.out.println("Studen from db : " + studdentFromDB);
		} finally {
			factory.close();
		}
	}

}
