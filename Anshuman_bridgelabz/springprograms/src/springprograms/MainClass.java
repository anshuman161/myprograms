package springprograms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springprograms.coreprograms.Student;

public class MainClass {
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springprograms/applicatioContext.xml");
		Address student = (Address) context.getBean("address");
		student.getname();
	}
}
