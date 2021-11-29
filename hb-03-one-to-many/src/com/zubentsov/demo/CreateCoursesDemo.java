
package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Course;
import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// create courses
			Course courseOne = new Course("baseball");
			Course courseSecond = new Course("cricket");

			// get instructor by id
			int instructorID = 1;
			Instructor instructor = session.get(Instructor.class, instructorID);

			// set courses in instructor
			instructor.addCourse(courseOne);
			instructor.addCourse(courseSecond);

			// save courses in db
			session.save(courseOne);
			session.save(courseSecond);

			session.getTransaction().commit();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

	}

}
