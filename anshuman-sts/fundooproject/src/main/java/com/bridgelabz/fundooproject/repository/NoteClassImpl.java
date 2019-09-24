package com.bridgelabz.fundooproject.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.UserInformation;

@Repository
public class NoteClassImpl implements Note 
{
	@Autowired
	private EntityManager entity;

	@Override
	public boolean save(NoteDetails details) 
	{
		System.out.println("inside repositry -above save method");
		Session session = entity.unwrap(Session.class);
		session.save(details);
		return true;
	}
	@Override
	public UserInformation findById(long userId) 
	{
		Session session = entity.unwrap(Session.class);
		Query query = session.createQuery("from UserInformation where userId=:userId");
		query.setParameter("userId", userId);
		System.out.println("user id inside repositry:-"+userId);
		return  (UserInformation) query.uniqueResult();
	}
	@Override
	public boolean updateNotes(NoteDetails details) {
		Session session = entity.unwrap(Session.class);
		session.createQuery("update NoteDetails note set note.tittle='"+details.getTittle()+"',note.description='"+details.getDescription()+"',note.isPin='"+details.isTrash()+"' ");
		return false;
	}

}
