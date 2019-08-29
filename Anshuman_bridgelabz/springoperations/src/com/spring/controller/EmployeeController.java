package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.beans.EmployeeDetails;
import com.spring.services.ServiceInterface;

@Controller
public class EmployeeController 
{
	@Autowired
	ServiceInterface service;
	
	@RequestMapping(value="/employeeform",method=RequestMethod.POST)
	public ModelAndView doregister(@ModelAttribute EmployeeDetails edetails)
	{
		ModelAndView mav=new ModelAndView();
		int check=service.doregister(edetails);
		if (check>0)
		{
			return new ModelAndView("loginpage");
		}
		else 
		{
			return new ModelAndView("registration");
		}
	}

	@PostMapping("/login")
	public ModelAndView dologin(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		EmployeeDetails edetails = new EmployeeDetails();
		edetails.setEmail(email);
		edetails.setPassword(password);
		String demo = service.dologin(edetails);
		if (demo != null) {
			mv.addObject("msg", "Welcome " + demo + ", You have successfully logged in.");
			mv.setViewName("homepage");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("loginpage");
		}
		return mv;
	}

}
