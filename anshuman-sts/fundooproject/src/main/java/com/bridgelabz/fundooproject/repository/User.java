package com.bridgelabz.fundooproject.repository;

import com.bridgelabz.fundooproject.model.UserInformation;

public interface User 
{
	public void save(UserInformation student);

	public UserInformation getUser(String email);

	public boolean saveVerfied(long id);
	
	public boolean changePassword(String password, Long userId);
}
