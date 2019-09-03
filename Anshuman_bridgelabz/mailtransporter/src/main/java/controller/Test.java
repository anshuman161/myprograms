package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
	public static void getmail()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("controller/applicationcontext.xml");
		MailMail m=(MailMail)context.getBean("mailMail");  
		String sender="anshumanjoshi161@gmail.com";//write here sender gmail id  
		String receiver="anshumanjoshi161@gmail.com";//write here receiver id  
		m.sendMail(sender,receiver,"i an sending a mail.","welcome");  		      
		System.out.println("success");  
		}  	
	
	public static void main(String[] args) 
	{  
	      
    Test.getmail();  		

}
}