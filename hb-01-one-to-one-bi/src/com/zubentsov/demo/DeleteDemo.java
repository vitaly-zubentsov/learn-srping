package com.zubentsov.demo;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			//get list of object from DB
			
			List<Instructor> instructors = session.createQuery("FROM Instructor").getResultList();
			printInstructor(instructors);
			
			//choose one instructor by id and associate objects(instructorDetail) and print 
			
			Random random = new Random();
			
			Instructor instructor = instructors.get(random.nextInt(instructors.size()));
			
			System.out.println("Instructor to delete : /n"  + instructor );
			
			
			//DELETE instructor
			// this will ALSO delete the instructorDetail because
			// CascadType.ALL
			
			session.delete(instructor);
			
			session.getTransaction().commit();

		
			// CHECK cascade delete
			session = factory.getCurrentSession();
			session.beginTransaction();

			//get list instructor detail and print
			List<InstructorDetail> instructorsDetail = session.createQuery("FROM InstructorDetail").getResultList();
			printInstructorsDetails(instructorsDetail);
			
			session.getTransaction().commit();


		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

	}

	private static void printInstructorsDetails(List<InstructorDetail> instructorsDetail) {
		System.out.println("Print list of instructors detail");
		for (InstructorDetail instructorDetail : instructorsDetail) {
			System.out.println(instructorDetail);
		}
	}

	private static void printInstructor(List<Instructor> instructors) {
		System.out.println("Print list of instructors");
		for (Instructor instructor : instructors) {
			System.out.println(instructor);
		}
	}

}
