package com.bridgelabz.addressbook.util;

import java.util.Scanner;

public class Shortcut 
{
  public void scannerforint()
  {
	 Scanner sc=new Scanner(System.in);
	 int num=sc.nextInt();
  }
  public void scannerforstring()
  {
	  Scanner sc=new Scanner(System.in);
		 String str=sc.next();
  }
  public void scannerforstringline()
  {
	  Scanner sc=new Scanner(System.in);
		 String str2=sc.nextLine();
  }
}
