package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.firstmavenproject.firstMavenProject.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session 
		Session session = factory.getCurrentSession();
		
		try
		{	
			//create a student object
			System.out.println("Creating 3 student object");
			Student s1 = new Student("Max", "Jusinski", "maxie_paxie@op.pl");
			Student s2 = new Student("Hubert", "Jusinski", "hubix1@wp.pl");
			Student s3 = new Student("Dawid", "Jusinski", "djusinski@gmail.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			session.save(s1);
			session.save(s2);  //Hello 
			session.save(s3);
			System.out.println("saving the students..");
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

}
