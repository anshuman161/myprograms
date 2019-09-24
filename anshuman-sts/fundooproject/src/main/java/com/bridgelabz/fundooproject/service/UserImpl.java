package com.bridgelabz.fundooproject.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.model.UserDto;
import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.model.UserLogIn;
import com.bridgelabz.fundooproject.model.UserResetPassword;
import com.bridgelabz.fundooproject.repository.UserClassImpl;
import com.bridgelabz.fundooproject.utilmethods.UtilMethods;

@Service
public class UserImpl implements UserService {
	@Autowired
	private UserClassImpl user;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private UtilMethods util;

	@Autowired
	private ModelMapper mapper;

	@Transactional
	@Override
	public void save(UserDto student) 
	{
		UserInformation checkValid = user.checkUser(student.getEmail());
		if (checkValid == null) {
			UserInformation information = mapper.map(student, UserInformation.class);
			String newPassword = bcrypt.encode(information.getPassword());
			information.setPassword(newPassword);
			information.setVerified(false);
			user.save(information);
			String tokens = util.generateTokens(information.getUserId());
			util.sendMail(student.getEmail(), "Email verifying", "http://localhost:8080/students/verify/" + tokens);
		}
	}

	@Transactional
	@Override
	public boolean isVerify(String token) {
		Long id = (long) util.parseToken(token);
		if (id != null) {
			user.saveVerfied(id);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean getLogIn(UserLogIn login) {
		UserInformation userInfo = user.checkUser(login.getEmail());
		if (userInfo != null) {
			if (bcrypt.matches(login.getPassword(), userInfo.getPassword()) && userInfo.isVerified() == true) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	@Override
	public boolean forgetPassword(String email) {
		UserInformation info = user.checkUser(email);
		if (info != null) {
			util.sendMail(info.getEmail(), "Reset Password", util.generateTokens(info.getUserId()));
			return true;
		} else {
			return false;
		}
	}
	@Transactional
	@Override
	public boolean resetPassword(UserResetPassword password, String token)
	{         
		if (password.getPassword().equals(password.getConfirmPassword())) 
		{
			long userId = util.parseToken(token);
			user.changePassword(bcrypt.encode(password.getPassword()), userId);
			return true;
		} else {
			return false;
		}
	}

}
