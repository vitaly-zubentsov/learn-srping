package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Course;
import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;
import com.zubentsov.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// get course
			int courseId = 12; // fix value, use for simplify example
			Course course = session.get(Course.class, courseId);

			// print course and related reviews
			System.out.println("Course : " + course);

			System.out.println("Course reviews : " + course.getReviews());
			
			//delete course
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