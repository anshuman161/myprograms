package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	public static void main(String[] args) {

		/*
		 * Configuration cfg = new
		 * Configuration().configure().addAnnotatedClass(Student.class)
		 * .addAnnotatedClass(Laptop.class);
		 */
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); 
		
	
		Laptop lap = new Laptop();
		lap.setLid(102);
		lap.setLname("HP");
        
		Laptop lap2 = new Laptop();
		lap.setLid(103);
		lap.setLname("Dell");
        
		Laptop lap3 = new Laptop();
		lap.setLid(104);
		lap.setLname("Lenovo");
		
		List<Laptop> al=new ArrayList<Laptop>();
		al.add(lap);
		al.add(lap2);
		al.add(lap3);
		
		Student stu = new Student();
		stu.setId(2);
		stu.setName("man");
		stu.setLaptop(al);
        
		session.persist(stu);
		
		tx.commit();
        session.close();
        System.out.println("success..........");
  
	}
}
