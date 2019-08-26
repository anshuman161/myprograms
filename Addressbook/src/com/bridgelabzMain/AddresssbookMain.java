package com.bridgelabzMain;
import java.util.Scanner;
public class AddresssbookMain 
{
private Scanner  sc=new Scanner (System.in);
Addressbookimplementation addressbook =new Addressbookimplementation();
private void mainMenu() 
      {
	System.out.println("adressbook");
	System.out.println("------------");
	System.out.println("1.creat a new addressbook");
	System.out.println("2.update an addressbppk");
	System.out.println("3.deleat an address from adressbook");
	System.out.println("4.exit");
	mainMenudetails();
      }
private void mainMenudetails()
   {
	try 
	{
		System.out.println("enter your choice");
		int menuOption =sc.nextInt();
	switch (menuOption) {
	case 1:
		addressbook.creatAddress();
		break;
	case 2:
		addressbook.updateAddress();
		break;
	case 3:
		addressbook.deleatAddress();
		break;
	case 4:
		addressbook.exitAddress();
		break;
		default:
			System.out.println("invalid nput try again va;id input");
	          }
	}
   }
	catch (exception e) 
	{
		e.printStackTrace();
		System.out.println("enter a number from 1 to 3");
		
	}
	

}
