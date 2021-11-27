package com.zubentsov.demo;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Instructor;
import com.zubentsov.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			printInstructorsDetail(instructorsDetail);

			// choose one instructor by id and associate objects(instructorDetail) and print

			Random random = new Random();

			int idInstructorDetail = instructorsDetail.get(random.nextInt(instructorsDetail.size())).getId();

			System.out.println("InstructorDetail id = " + idInstructorDetail);

			// get instructorDetail by id from instrusctor from list
			// this will ALSO get the instructor because
			// CascadType.ALL

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, idInstructorDetail);

			System.out.println("InstructorDetail from db by id: " + instructorDetail);

			System.out.println("Instructor from InstructorDetail" + instructorDetail.getInstructor());

			session.getTransaction().commit();

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
