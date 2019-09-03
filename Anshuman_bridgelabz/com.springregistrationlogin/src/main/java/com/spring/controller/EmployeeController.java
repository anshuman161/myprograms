
package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.beans.EmployeeDetails;
import com.spring.services.ServiceImplementation;
import com.spring.util.Utility;

@Controller
public class EmployeeController {

	@Autowired
	private ServiceImplementation service;

	@Autowired
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	private Utility util;

	@RequestMapping("/registrationpage")
	public String viewRegister() {
		System.out.println("entered into emp");
		String name = "registrationpage";
		return name;
	}

	@RequestMapping("/loginpage")
	public String viewloginpage() {
		String name = "loginpage";
		System.out.println("entered into login");
		return name;
	}

	@RequestMapping(value = "/employeeform", method = RequestMethod.POST)
	public ModelAndView doregister(@ModelAttribute EmployeeDetails edetails) {
		String password = edetails.getPassword();

		ModelAndView mav = new ModelAndView();
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

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public ModelAndView dologin(HttpSession session, @ModelAttribute EmployeeDetails employee) {
		ModelAndView mv = new ModelAndView();
		String password = employee.getPassword();
		String newPassword = util.encryption(password);
		employee.setPassword(newPassword);
		EmployeeDetails demo = service.dologin(employee);
		System.out.println(demo);
		if (demo != null) {

			session.setAttribute("email", employee.getEmail());
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
	public String logout(HttpSession session) {
		session.removeAttribute("email");
		session.invalidate();
		return "loginpage";
	}

	@RequestMapping("/forgetpasswordpage")
	public String viewforgetpassword() {
		String name = "forgetpasswordpage";
		System.out.println("entered into forgetpassword");
		return name;
	}
	
	@PostMapping("/resetpassword")
	public ModelAndView checkMail(@ModelAttribute EmployeeDetails employee) 
	{
		
		EmployeeDetails details = service.doemail(employee);
		if (details != null) {
			System.out.println("inside mail controller");
			String from = "anshumanjoshi161@gmail.com";
		 	String  to = employee.getEmail();
			
			System.out.println("inside chekmail method :-"+to);
			String subject = "Reset Password !";
			String msg = "http://localhost:8081/springregistrationlogin/resetPassword";

			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(msg);
			System.out.println(message);
			mailSender.send(message);
			System.out.println("done");
		}
		return new ModelAndView("loginpage");
	}
	
	@RequestMapping(value="/resetPassword",method=RequestMethod.GET)
	public String viewreset() 
	{
		return "resetPassword";
	}
	@GetMapping("/newPassword")
	public ModelAndView resetPasscode(@ModelAttribute EmployeeDetails edetails)
	{
		
		String password = edetails.getPassword();
		System.out.println(password);
		String newPassword = util.encryption(password);
		edetails.setPassword(newPassword);
		int demo= service.resetpassword(edetails);
		if (demo>0)
		{
		 return new ModelAndView("loginpage");	
		}
		else 
		{
			return new ModelAndView("error");
		}
	}
	

}
