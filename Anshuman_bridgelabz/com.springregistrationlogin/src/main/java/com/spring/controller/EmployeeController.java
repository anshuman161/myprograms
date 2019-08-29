
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
import com.spring.services.ServiceImplementation;

@Controller
public class EmployeeController {

	@Autowired
	ServiceImplementation service;

	@RequestMapping("/registrationpage")
	public String viewregister() {
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
	
	@RequestMapping(value ="/employeeform", method = RequestMethod.POST)
	public ModelAndView doregister(@ModelAttribute EmployeeDetails edetails) {
		System.out.println("1111111");
		ModelAndView mav = new ModelAndView();
		int check = service.doregister(edetails);
		System.out.println(check);
		if (check > 0) {
			return new ModelAndView("loginpage");
		} else {
			return new ModelAndView("registration");
		}
	}
	@PostMapping(value="/login")
	public ModelAndView dologin(@ModelAttribute EmployeeDetails employee) {
		ModelAndView mv = new ModelAndView();
		
		EmployeeDetails demo = service.dologin(employee);
		System.out.println(demo);
		if (demo != null) 
		{
			System.out.println("inside dologin :-");
			mv.addObject("msg", "homepage" + demo + ", You have successfully logged in.");
			mv.setViewName("homepage");
		}
		else
		{
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("loginpage");
		}
		return mv;
	}
	
	

}
