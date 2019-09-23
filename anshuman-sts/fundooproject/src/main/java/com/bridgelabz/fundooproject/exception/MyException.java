package com.bridgelabz.fundooproject.exception;

public class MyException extends Exception
{
   public MyException(String s) {
   super(s);
}
}
class A
{
    public void name() throws MyException
    {
	 throw new MyException("geeks");	
	}	
}
