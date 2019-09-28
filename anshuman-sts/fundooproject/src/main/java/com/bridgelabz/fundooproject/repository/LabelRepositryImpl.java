package com.bridgelabz.fundooproject.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooproject.model.LabelDetails;
import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.UserInformation;

@Repository
public class LabelRepositryImpl implements Label
{
@Autowired
EntityManager entity;

@Override
public UserInformation findById(long userId) 
{
	Session session = entity.unwrap(Session.class);
	Query query = session.createQuery("from UserInformation where userId=:userId");
	query.setParameter("userId", userId);
	return  (UserInformation) query.uniqueResult();
}
	@Override
	public void save(LabelDetails details)
	{
		Session session = entity.unwrap(Session.class);
		session.save(details);
	}
	
	@Override
	public NoteDetails findNoteById(long id) {
		Session session = entity.unwrap(Session.class);
		Query query = session.createQuery("from NoteDetails where noteId=:id");
		query.setParameter("id", id);
		return  (NoteDetails) query.uniqueResult();
	}
  
}
