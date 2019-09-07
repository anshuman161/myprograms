package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TrackOperation {

   @Pointcut("execution(* aop.*.*(..))")
	public void msg() {
	}

	@Before("execution (public void msg())")
	public void myadvice() {
		System.out.println("myadvice from trackoperation class is calling.");
	}
}