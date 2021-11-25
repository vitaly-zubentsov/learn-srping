package com.zubentsov.demo;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// get list of object from DB

			List<InstructorDetail> instructorsDetail = session.createQuery("FROM InstructorDetail").getResultList();
			instructorsDetail = null;

			// if not empty delete one instructor detail
			if (!instructorsDetail.isEmpty()) {

				printInstructorsDetail(instructorsDetail);
				Random random = new Random();

				InstructorDetail instructorDetail = instructorsDetail.get(random.nextInt(instructorsDetail.size()));

				System.out.println("Instructor to delete : /n" + instructorDetail);

				// DELETE instructor
				// this will ALSO delete the instructorDetail because
				// CascadType.ALL

				session.delete(instructorDetail);

				session.getTransaction().commit();

				// CHECK cascade delete
				session = factory.getCurrentSession();
				session.beginTransaction();

				// get list instructor detail and print
				instructorsDetail = session.createQuery("FROM InstructorDetail").getResultList();
				printInstructorsDetail(instructorsDetail);

				session.getTransaction().commit();
			} else {
				System.out.println("Instructor detail is empty. Nothing to delete");
			}

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

	}

	private static void printInstructorsDetail(List<InstructorDetail> instructorsDetail) {
		System.out.println("Print list of instructors detail");
		for (InstructorDetail instructorDetail : instructorsDetail) {
			System.out.println(instructorDetail);
		}
	}

}
