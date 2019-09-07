package demo;

public class Student 
{
 public boolean testname(String name,String sname)
 {
  	if (name.equalsIgnoreCase(sname))
  	{
	 return true;	
	}
  	else {
		return false;
	}
 }
 
 public int[] addToArray(int number[])
 {
     int length=number.length;
     int output[]=new int[length];
     for (int i = 0; i < output.length; i++) {
		output[i]=number[i]+1;
	}
	return output;
 }
 
 public void testException(int no)
 {
	 int n=10/no;
      System.out.println("Result is "+n);
      
 }
}
