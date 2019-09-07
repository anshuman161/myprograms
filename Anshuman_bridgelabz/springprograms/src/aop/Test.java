package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	
	public static void main(String[] args) 
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("111");
		Operation e =context.getBean("getBean",Operation.class);  
        System.out.println("222");
        e.msg();
	}
}
