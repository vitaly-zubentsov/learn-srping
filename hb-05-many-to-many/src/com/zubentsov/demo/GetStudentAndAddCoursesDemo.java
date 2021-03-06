package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Course;
import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;
import com.zubentsov.demo.entity.Review;
import com.zubentsov.demo.entity.Student;

public class GetStudentAndAddCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// get student
			int studentId = 1; // fix to simplify example
			Student student = session.get(Student.class, studentId);

			// DELETE student
			// should delete only student and rows in course_student table
			session.delete(student);

			int courseId = 10; // fix to simplify example

			Course course = session.get(Course.class, courseId);

			// DELETE courses
			// should delete only student and rows in course_student table
			session.delete(course);

			session.getTransaction().commit();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

	}

}