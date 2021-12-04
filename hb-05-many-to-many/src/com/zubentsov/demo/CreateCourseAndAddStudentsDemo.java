package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Course;
import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;
import com.zubentsov.demo.entity.Review;
import com.zubentsov.demo.entity.Student;

public class CreateCourseAndAddStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// create course and save
			Course course = new Course("How to spend all money in one day");
			
			session.save(course);
			// create students and add them to course

			Student student1 = new Student("Alan", "Wake", "alanlon@g.com");
			Student student2 = new Student("Mr", "Hat", "mr@hat.com");

			course.addStuden(student1);
			course.addStuden(student2);

			//save student
			session.save(student1);
			session.save(student2);

			System.out.println("Save students " + course.getStudents());

			session.getTransaction().commit();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

	}

}