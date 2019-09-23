package com.bridgelabz.fundooproject.model;

import org.springframework.stereotype.Component;

@Component
public class UserResetPassword {
 private String password;
 private String confirmPassword;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	password = password;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

}
