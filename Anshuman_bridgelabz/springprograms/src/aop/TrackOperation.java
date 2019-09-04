package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Component
@Aspect
@EnableAspectJAutoProxy
public class TrackOperation
{

	@Pointcut("execution(*Operation.*(..))")
	public void msg() {
	}
 
	@Before("msg()")
public void myadvice(JoinPoint jointpoint)
{
System.out.println("myadvice is calling.");	
}
}
