package springprograms.coreprograms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springprograms.coreprograms.Student;

public class MainClass {
	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("springprograms/coreprograms/applicatioContext.xml");
	              Student student=(Student)context.getBean("student");
	              student.getobject();
	}
}
