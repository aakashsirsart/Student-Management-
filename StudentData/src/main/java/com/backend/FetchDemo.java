package com.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Student student =(Student)session.load(Student.class, 104);
		
		System.out.println(student);
		
		Adress ad = (Adress)session.get(Adress.class, 1);
		
		System.out.println(ad.getStreet()+" : "+ad.getAdressId() +" : " +ad.getCity());
		
		session.close();
		factory.close();
	}

}
