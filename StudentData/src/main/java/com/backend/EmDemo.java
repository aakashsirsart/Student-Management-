package com.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Aaskash");
		student1.setCity("Pune");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Java");
		certificate.setDuration("6 Months");
		
		student1.setCerti(certificate);
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Sankalp");
		student2.setCity("Pune");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Python");
		certificate1.setDuration("6 Months");
		
		student2.setCerti(certificate);
		
		Session s= factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(student1);
		s.save(student2);
		
		s.close();
		factory.close();
	}

}
