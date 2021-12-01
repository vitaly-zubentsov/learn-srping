package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.zubentsov.demo.entity.Course;
import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// Solution 2: get HQL Query Fetch

			// get instructor by id
			int instructorId = 1;

			Query<Instructor> query = session.createQuery(
					"SELECT i FROM Instructor i " + "JOIN FETCH i.courses " + "WHERE i.id=:theInstructorId",
					Instructor.class);
			query.setParameter("theInstructorId", instructorId);

			Instructor instructor = query.getSingleResult();

			session.getTransaction().commit();

			// try use instructor courses after commit

			System.out.println("Instructor courses after commit" + instructor.getCourses());

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

	}

}