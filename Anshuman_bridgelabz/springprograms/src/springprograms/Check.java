package springprograms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Check {
	public static void main(String[] args) 
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(MainClass2.class);
		Demo demo = context.getBean("demobean",Demo.class);
		demo.m1();
	}
}
