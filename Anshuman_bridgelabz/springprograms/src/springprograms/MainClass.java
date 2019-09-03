package springprograms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springprograms.coreprograms.Student;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springprograms/applicatioContext.xml");
		ForQualifier student = (ForQualifier) context.getBean("address");
		student.value();
	}
}
