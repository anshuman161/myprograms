
package com.bridgelabz.userloginregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.userloginregistration.model.EmployeeDetails;
import com.bridgelabz.userloginregistration.services.ServiceImplementation;
import com.bridgelabz.userloginregistration.services.ServiceInterface;
import com.bridgelabz.userloginregistration.util.Utility;

@Controller
public class EmployeeController {

	@Autowired
	private ServiceImplementation service;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	Utility util;

	@RequestMapping("/registrationpage")
	public String viewRegister() {

		return "registrationpage";

	}

	@RequestMapping("/loginpage")
	public String viewLogInPage()
	{
		return "loginpage";

	}

	@PostMapping("/employeeform")
	public ModelAndView doRegister(@ModelAttribute EmployeeDetails edetails) {
		String password = edetails.getPassword();
		String newPassword = util.encryption(password);
		edetails.setPassword(newPassword);
		int check = service.doregister(edetails);
		System.out.println(check);
		if (check > 0) {
			return new ModelAndView("loginpage");
		} else {
			return new ModelAndView("registration");
		}
	}

	@PostMapping("/login")
	public ModelAndView doLogIn(@ModelAttribute EmployeeDetails employee) {
		ModelAndView mv = new ModelAndView();
		String password = employee.getPassword();
		String newPassword = util.encryption(password);
		employee.setPassword(newPassword);
		EmployeeDetails demo = service.dologin(employee);
		if (demo != null) {
			System.out.println("inside dologin :-");
			mv.addObject("msg", "homepage" + demo + ", You have successfully logged in.");
			mv.setViewName("homepage");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("loginpage");
		}
		return mv;
	}

	@GetMapping("/logoutwork")
	public String logOut() {
		return "loginpage";
	}

	@RequestMapping("/forgetpasswordpage")
	public String viewForgetPassword() {
		String name = "forgetpasswordpage";
		System.out.println("entered into forgetpassword");
		return name;
	}

	@PostMapping("/forgetpassword")
	public ModelAndView checkMail(@ModelAttribute EmployeeDetails employee) {
		EmployeeDetails details = service.doemail(employee);
		if (details != null) {
			System.out.println("inside mail controller");
			String from = "anshumanjoshi161@gmail.com";
			String to = employee.getEmail();
			String subject = "Reset Password !";
			String msg = "http://localhost:8081/app/resetPassword";
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(msg);
			System.out.println("Above send method:-");
			mailSender.send(message);
			System.out.println("done");
		}
		return new ModelAndView("loginpage");
	}

	@GetMapping("/resetPassword")
	public String viewReset() {
		return "resetPassword";
	}

	@PostMapping("/newPassword")
	public ModelAndView resetPasscode(@ModelAttribute EmployeeDetails edetails) {
		String password = edetails.getPassword();
		String newPassword = util.encryption(password);
		edetails.setPassword(newPassword);
		int demo = service.resetpassword(edetails);
		if (demo > 0) {
			return new ModelAndView("loginpage");
		} else {
			return new ModelAndView("error");
		}
	}

}
