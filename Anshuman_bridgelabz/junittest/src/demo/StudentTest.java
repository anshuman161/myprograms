package demo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class StudentTest {
	/*
	 * @Before public void before() { System.out.println("Before"); }
	 */

	@Test
	void testequals()
	{
       System.out.println("third :-"+"equals");		
		Student student = new Student();
		assertTrue("it is not executing", student.testname("krishna", "krishna"));
	} 
	
	@Test
	void testsum()
	{
		System.out.println("first :-"+"sum");
		Student student = new Student();
		int expexted[] = new int[] { 5, 6 };
		assertArrayEquals(expexted, student.addToArray(new int[] { 4, 5 }));
	}
 
	@Test
	 void testerror() 
	{
		System.out.println("second :-"+"Exception");
		Student student=new Student();
		//assertThrows(ArithmeticException.class, student.testException(0));
		assertThrows(ArithmeticException.class, () -> {
			student.testException(0);
	    });
	}
	
}
