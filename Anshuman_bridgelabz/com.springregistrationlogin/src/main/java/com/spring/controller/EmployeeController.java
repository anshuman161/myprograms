
package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.beans.EmployeeDetails;
import com.spring.services.ServiceImplementation;
import com.spring.util.Utility;

@RestController
public class EmployeeController 
{

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
	public String viewLogInPage() {
		String name = "loginpage";
		System.out.println("entered into login");
		return name;
	}

	@RequestMapping(value = "/employeeform", method = RequestMethod.POST)
	public ModelAndView doRegister(@ModelAttribute EmployeeDetails edetails) {
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

	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String doLogIn(@RequestParam String email, @RequestParam String password) {
		//ModelAndView mv = new ModelAndView();
		//String password = employee.getPassword();
		//String newPassword = util.encryption(password);
		//employee.setPassword(newPassword);
		//EmployeeDetails demo = service.dologin(employee);
		EmployeeDetails empdetails=new EmployeeDetails();
		empdetails.setEmail(email);
		empdetails.setPassword(password);
		EmployeeDetails demo = service.dologin(empdetails);
		
		System.out.println(demo);
		if (demo != null) 
		{
			System.out.println("inside dologin :-");
			//mv.addObject("msg", "homepage" + demo + ", You have successfully logged in.");
			//mv.setViewName("homepage");
		 return "success";
		} 
		else
		{
			//mv.addObject("msg", "Invalid user id or password.");
			//mv.setViewName("loginpage");
		  return "fail";
		}
		//return mv;
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
	
	@PostMapping("/resetpassword")
	public ModelAndView checkMail(@ModelAttribute EmployeeDetails employee) 
	{
		
		EmployeeDetails details = service.doemail(employee);
		if (details != null)
		{
			System.out.println("inside mail controller");
			String from = "anshumanjoshi161@gmail.com";
		 	String  to = employee.getEmail();
			String subject = "Reset Password !";
			String msg = "http://localhost:8081/springregistrationlogin/resetPassword";
 
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(msg);

			mailSender.send(message);
			System.out.println("done");
		}
		return new ModelAndView("loginpage");
	}
	
	@RequestMapping(value="/resetPassword",method=RequestMethod.GET)
	public String viewReset() 
	{
		return "resetPassword";
	}
	@GetMapping("/newPassword")
	public ModelAndView resetPasscode(@ModelAttribute EmployeeDetails edetails)
	{
		
		String password = edetails.getPassword();
		
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
