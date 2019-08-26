
public class Listsingali{
	ListNode head;
	
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
		while(last!=null) {
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
	public void Printelement() {
		ListNode current=head;
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
			
		}
	}
	public static void main(String[] args) {
		
		Listsingali list=new Listsingali();
		list.adddata(45);
		list.adddata(5);
		list.removedata();
		list.Printelement();
	}
	
	

}
