package com.hibernateManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Result {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(service);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Laptop lap = new Laptop();
		lap.setLname("Dell");

		Student sts = new Student();
		sts.setName("raina");
		//sts.setLaptop(lap);

		Student sts1 = new Student();
		sts1.setName("kohli");
		sts1.setLaptop(lap);

		session.save(sts);
		session.save(sts1);
		tx.commit();
		session.close();
		System.out.println("success");

	}
}
