package com.zubentsov.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// add new student
			Student student = new Student("Nicol", "Aniston", "nia@google.com");

			System.out.println("Studen before update " + student);

			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();

			// show list of students
			session = factory.getCurrentSession();

			session.beginTransaction();

			List<Student> students = session.createQuery("FROM Student").getResultList();

			System.out.println("Student list before deleting : ");
			displayStudents(students);

			session.getTransaction().commit();

			// delete student
			/*session = factory.getCurrentSession();

			session.beginTransaction();
			
			Student studentInDb = session.get(Student.class, student.getId());

			session.delete(studentInDb);

			session.getTransaction().commit();*/
			
			// Delete by query
			
			session = factory.getCurrentSession();

			session.beginTransaction();
			
			session.createQuery("DELETE FROM Student where id="+student.getId()).executeUpdate();

			session.getTransaction().commit();

			// check deleting
			session = factory.getCurrentSession();

			session.beginTransaction();

			students = session.createQuery("FROM Student").getResultList();

			System.out.println("Student list after deleting : ");
			displayStudents(students);

			session.getTransaction().commit();

			

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("\n");
	}

}
