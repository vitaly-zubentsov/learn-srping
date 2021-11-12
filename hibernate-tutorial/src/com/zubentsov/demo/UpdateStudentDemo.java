package com.zubentsov.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			Student student = new Student("Pavel", "Zavodnov", "pz@google.com");

			System.out.println("Studen before update " + student);

			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
	
			session.beginTransaction();
			
			Student tempStudent = session.get(Student.class, student.getId());
			
			tempStudent.setFirstName("Mary");

			tempStudent.setLastName("Go"); 
			
			session.getTransaction().commit();
			
			
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student updatedStudent = session.get(Student.class, tempStudent.getId());
			
			session.getTransaction().commit();
			

			System.out.println("Studen after update in db : " + updatedStudent);
			
			
			//Update by query
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("UPDATE Student set email='unaviliable'").executeUpdate();
			
			List<Student> students = session.createQuery("FROM Student").getResultList();
			
			System.out.println("Students after:  UPDATE Student set email='unaviliable'");
			
			for (Student nextStudent : students) {
				
				System.out.println(nextStudent);
				
			}
			session.getTransaction().commit();
			
			

		} finally {
			factory.close();
		}

	}

}
