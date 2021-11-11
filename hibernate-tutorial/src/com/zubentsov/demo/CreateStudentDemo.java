package com.zubentsov.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zubentsov.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		
		Session session = factory.getCurrentSession();
		
		Student tempStudent = new Student("Pavel", "Zavodnov", "pz@google.com");
		
		System.out.println("Studen id before save in db : " + tempStudent.getId());
		
		session.beginTransaction();
		
		session.save(tempStudent);
		
		session.getTransaction().commit();
		
		System.out.println("Save student to db");
		
		System.out.println("Studen id after save in db : " + tempStudent.getId());
		
		
		
	}
	

}
