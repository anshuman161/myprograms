package com.bridgelabz.fundooproject.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.model.UserResetPassword;

@Repository
public class UserClassImpl implements User
{
	@Autowired
	private EntityManager entityManager;
	@Override
	public UserInformation checkUser(String email) 
	{
		Session currentsession = entityManager.unwrap(Session.class);
		Query query = currentsession.createQuery("from UserInformation where email=:email");
		query.setParameter("email", email);
		return (UserInformation) query.uniqueResult();          
	}
	@Override
	public void save(UserInformation student) 
	{
		Session currentsession = entityManager.unwrap(Session.class);
		currentsession.save(student);
	}
	public boolean saveVerfied(long id) 
	{
		Session currentsession = entityManager.unwrap(Session.class);
		Query query = currentsession
				.createQuery("update UserInformation set isVerified=:isVerified where userId=:userId");
		query.setParameter("isVerified", true);
		query.setParameter("userId", id);
		int demo = query.executeUpdate();
		
		if (demo>0)
		{
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean changePassword(String password, Long userId)
	{
		Session currentsession = entityManager.unwrap(Session.class);
		Query query=currentsession.createQuery("update UserInformation set password=:password where userId=:userId");
		    query.setParameter("password", password);
            query.setParameter("userId", userId);
            int demo = query.executeUpdate();
    		if (demo>0)
    		{
    			return true;
    		}
    		else 
    		{
    			return false;
    		}
	}
	

	

}
