package abc;

public class Listsingali{
	ListNode head;
	ListNode newNode;
	class ListNode{
		ListNode next;
		int data;
		public ListNode(int data) {
			this.data=data;
			}
	}
	public Listsingali() {
		this.head=head;
	}
	public void removedata() {
		ListNode last=head;
		ListNode previousNode=null;
		if(last!=null) {
			previousNode=last;
			last=last.next;
			
		}
		previousNode.next=null;
	}

	public void adddata(int data) {
		ListNode newNode=new ListNode(data);
		newNode.next=head;
		head=newNode;
		
		 
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
	public void Printelement() {
		ListNode current=head;
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
			
		}
	}
	public static void main(String[] args) {
		
		Listsingali list=new Listsingali();
		list.adddata(4536);
		list.adddata(455);
		list.adddata(345);
		list.adddata(5);
		//list.removedata();
		list.Printelement();
	}
	
	

}

