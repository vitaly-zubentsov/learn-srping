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

			// get list of instructorDetail from DB

			List<InstructorDetail> instructorsDetail = session.createQuery("FROM InstructorDetail").getResultList();

			// if not empty delete one random instructor detail
			if (!instructorsDetail.isEmpty()) {

				printInstructorsDetail(instructorsDetail);
				Random random = new Random();

				InstructorDetail instructorDetail = instructorsDetail.get(random.nextInt(instructorsDetail.size()));

				System.out.println("InstructorDetail to delete : /n" + instructorDetail);

				System.out
						.println("Instructor associated with instructorDetail : /n" + instructorDetail.getInstructor());

				// save id of associated instructor to check deleting
				int associatedInstructorID = instructorDetail.getInstructor().getId();
				// for delete instructorDetail we need
				// remove associated object reference
				// break bidirectional link

				instructorDetail.getInstructor().setInstructorDetail(null);

				session.delete(instructorDetail);

				session.getTransaction().commit();

				// CHECK non cascade delete
				session = factory.getCurrentSession();
				session.beginTransaction();

				Instructor instructor = session.get(Instructor.class, associatedInstructorID);
				System.out.println("Associated instructor : " + instructor);

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
