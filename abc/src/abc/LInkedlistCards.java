package abc;

public class LInkedlistCards {
	
	ListNode head;
	ListNode newNode;
class ListNode
{
	int data;
	ListNode next;
	public ListNode(int data)
	{
		this.data=data;
		this.next=null;
		
	}
 }
public LInkedlistCards()
{
	head=null;
}
public void Sortlist()
{
	
	ListNode current=head;
	ListNode temp=null;
	while(current!=null&&current.data<newNode.data)
	{
		temp=current;
		current=current.next;
	}
	newNode.next=current;
	temp.next=newNode;
	System.out.print(head.data);
}
public static void main(String[] args) {
	LInkedlistCards ll=new LInkedlistCards();
	
}
}
