package aop;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@ComponentScan
@Configurable
@EnableAspectJAutoProxy
public class AppConfig
{
	@Bean
     public Operation getBean()
     {
    	 return new Operation();
     }
	
	
	
	
	
}
