package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Course;
import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create object
			InstructorDetail instructorDetail = new InstructorDetail("youtubeAny", "play football");

			Instructor instructor = new Instructor("Ivan", "Ivanov", "ivani@mail.ru");

			// associate the objects
			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();

			// this will ALSO save the instructorDetail because
			// CascadType.ALL
			session.save(instructor);

			session.getTransaction().commit();

			// CHECK
			session = factory.getCurrentSession();

			session.beginTransaction();

			InstructorDetail instructorDetailFromBD = session.get(InstructorDetail.class, instructorDetail.getId());

			session.getTransaction().commit();

			System.out.println("Instructor detail from bd :" + instructorDetailFromBD);

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

	}

}