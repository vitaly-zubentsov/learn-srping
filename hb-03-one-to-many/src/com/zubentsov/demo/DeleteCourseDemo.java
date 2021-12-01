package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Course;
import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int instructorId = 1;

			Instructor instructor = session.get(Instructor.class, instructorId);

			System.out.println("Instructor : " + instructor);

			System.out.println("Courses for the instructor" + instructor.getCourses());
			
			Course course = session.get(Course.class, 15);
			session.delete(course);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();

			session.beginTransaction();
			
			Instructor instructor1 = session.get(Instructor.class, instructorId);
			System.out.println("Courses for the instructor after delete" + instructor1.getCourses());

			session.getTransaction().commit();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

	}

}
