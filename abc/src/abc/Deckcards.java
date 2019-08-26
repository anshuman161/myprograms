package abc;
import java.util.Scanner;



import java.util.Random;
public class Deckcards

{
	ListNode head;
	ListNode newNode;
	class ListNode{
		ListNode next;
		int data;
		public ListNode(int data) {
			this.data=data;
			next=null;
		}
	
		}
public 	Deckcards() {
	head=null;
	}
public ListNode SortDeck() {
	ListNode current=head;
	ListNode temp=null;
	while(current!=null && current.data<newNode.data) {
		temp=current;
		current=current.next;
	}
	newNode.next=current;
	temp.next=newNode;
	return head;
}
	
		
	
	public static void main(String []args)
	{
	//Scanner sc=new Scanner (System.in);
	//int number=sc.nextInt();
	Random r=new Random();
	
	int i,j,number;
	//int arr[][]=new int[4][9];
	//Deckcards ll=new Deckcards();
	//ll.SortDeck(arr[i][j]);
	
		
for(i=1;i<=4;i++)
{ 
	System.out.println(i+" boy obtain cards are -------->>>>>");
	System.out.println();
for( j=1;j<=9;j++) {
	 number =r.nextInt(53);
	
	if(number==1||number==14||number==27||number==40)
	{
		System.out.println(". your card is ace amd dimond");
	}
		else if(number==2||number==15||number==28||number==41)
		{
			System.out.print(" 2 ");
		}
	
			else if(number==3||number==16||number==29||number==42)
			{
				System.out.print(" 3 ");
			}
		
		else if(number==4||number==17||number==30||number==43)
		{
			System.out.print(" 4 ");
		}

		else if(number==5||number==18||number==31||number==44)
		{
			System.out.print(" 5 ");
		}
		else if(number==6||number==19||number==32||number==45)
		{
			System.out.print(" 6 ");
		}
		else if(number==7||number==20||number==33||number==46)
		{
			System.out.print(" 7 ");
		}
	
		
		
		else if(number==8||number==21||number==34||number==47)
		{
			System.out.print(" 8");
		}
		else if(number==9||number==22||number==35||number==48)
		{
			System.out.print(" 9");
		}

		else if(number==10||number==23||number==36||number==49)
		{
			System.out.print(" 10");
		}
		else if(number==11||number==24||number==37||number==50)
		{
			System.out.print("jack");
		}
	
		else if(number==12||number==25||number==38||number==51)
		{
			System.out.print("  queen");
		}
		else if(number==13||number==26||number==39||number==52)
		{
			System.out.print("  king");
		}
		if(number<=13&&number>=1)
		{
			System.out.println(" club");
		}
		else if(number<=26&&number>=14)
		{
			System.out.println(" diamond");
		}
		else if(number<=39&&number>=27)
		{
			System.out.println(" heart");
		}
		else if(number<=52&&number>=40)
		{
			System.out.println(" spades");
		}
		System.out.println();
		
	
	
}
}

}}