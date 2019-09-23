package com.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernateManyToOne.Laptop;
import com.hibernateManyToOne.Student;

public class MainClass {
	public static void main(String[] args) 
	{
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
		Answer an1 = new Answer();
		an1.setId(100);
		an1.setAnswername("Java is a programming language");
		an1.setPostedBy("Ravi Malik");

		Answer an2 = new Answer();
		an2.setId(200);
		an2.setAnswername("Java is a platform");
		an2.setPostedBy("Sudhir Kumar");
	

		Question q1 = new Question();
		q1.setId(101);
		q1.setQname("What is Java?");
		q1.getAnswers().add(an1);
		q1.getAnswers().add(an2);

	
        session.save(q1);
        
		tx.commit();
		session.close();
		System.out.println("success");
	}
}
