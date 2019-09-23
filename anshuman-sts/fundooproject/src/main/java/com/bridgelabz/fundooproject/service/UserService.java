package com.bridgelabz.fundooproject.service;

import com.bridgelabz.fundooproject.model.UserDto;
import com.bridgelabz.fundooproject.model.UserLogIn;
import com.bridgelabz.fundooproject.model.UserResetPassword;

public interface UserService 
{
	public void save(UserDto student);

	public boolean getLogIn(UserLogIn login);

	public boolean isVerify(String token);

	public boolean forgetPassword(String email);

	public boolean resetPassword(UserResetPassword password,String token);
	
}
