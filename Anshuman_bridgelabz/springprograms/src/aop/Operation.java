package aop;

import org.springframework.stereotype.Component;

@Component
public class Operation 
{	
	public void msg() 
	{
		System.out.println("msg from operation class method invoked");
	}	
}
