package com.bridgelabz.fundooproject.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.exception.UserException;
import com.bridgelabz.fundooproject.model.UserDto;
import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.model.UserLogIn;
import com.bridgelabz.fundooproject.model.UserResetPasswordDto;
import com.bridgelabz.fundooproject.repository.UserRepositry;
import com.bridgelabz.fundooproject.utilmethods.Utility;

@Service
public class UserServieImpl implements UserService 
{
	@Autowired
	private UserRepositry user;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private Utility util;

	@Autowired
	private ModelMapper mapper;

	@Transactional
	@Override
	public void save(UserDto userDto) 
	{
		UserInformation userinformation = user.getUser(userDto.getEmail());
		if (userinformation == null) 
		{
			UserInformation information = mapper.map(userDto, UserInformation.class);
			String newPassword = bcrypt.encode(information.getPassword());
			information.setPassword(newPassword);
			information.setVerified(false);
			user.save(information);
			String tokens = util.generateTokens(information.getUserId());
			util.sendMail(userDto.getEmail(), "Email verifying", "http://localhost:8080/user/verify/" + tokens);
		}
		else 
		{
			 throw new UserException("User Already exist");
		}
	}

	@Transactional
	@Override
	public void isVerify(String token) 
	{
		System.out.println("inside service verifivation");
		Long id = (long) util.parseToken(token);
		if (id != null) {
			user.saveVerfied(id);
			
		} else {
			 throw new UserException("token verification failed");
		}
	}

	@Transactional
	@Override
	public void getLogIn(UserLogIn login) {
		UserInformation userInfo = user.getUser(login.getEmail());
		if (userInfo != null) 
		{
			if (bcrypt.matches(login.getPassword(), userInfo.getPassword()) && userInfo.isVerified() == true) {
				
			} else {
				throw new UserException("Wrong Password Or User is Not Verified");
			}
		} else {
			 throw new UserException("User Not Exist");
		}

	}

	@Override
	public void forgetPassword(String email) {
		UserInformation info = user.getUser(email);
		if (info != null) {
			util.sendMail(info.getEmail(), "Reset Password", util.generateTokens(info.getUserId()));
			
		} else {
			throw new UserException("User Not Exist");
		}
	}
	@Transactional
	@Override
	public void resetPassword(UserResetPasswordDto password, String token)
	{         
		if (password.getPassword().equals(password.getConfirmPassword())) 
		{
			long userId = util.parseToken(token);
			user.changePassword(bcrypt.encode(password.getPassword()), userId);
			
		} 
		else
		{
			throw new UserException("Password and Confirm password are not matched.");
		}
	}

	

}
