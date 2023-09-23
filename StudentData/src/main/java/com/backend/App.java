package com.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args)throws IOException {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student student = new Student();

		student.setId(104);
		student.setName("Avinash");
		student.setCity("Aurangabad");

		System.out.println(student);
		
		Adress ad =new Adress();
		
		ad.setStreet("Street 119");
		ad.setCity("Pimpri Chichwad");
		ad.setOpen(true);
		ad.setAddDate(new Date());
		ad.setX(1416.1403);
		
		FileInputStream fis =new FileInputStream("src/main/java/pngwing.com.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(student);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done");
	}
}
