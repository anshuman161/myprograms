
public class Stackelement {
	ListNode top;
	int length ;
	class ListNode
	{
		int data;
		ListNode next;
		public ListNode(int data)
		{
			this.data=data;
			
		}
	}
	public  Stackelement() 
	{
		top=null;
		length=0;
	}
	public int length()
	{
		return length;
	}
	public boolean isempty() {
		return length==0;
	}
	public void push(int data) {
		ListNode temp=new ListNode(data);
		temp.next=top;
		top=temp;
		length++;
	}
	public int pop() {
		if(isempty())
		{
			throw new EmptyStackException(); 
		}
		int result=top.data;
		top=top.next;
		length--;
		return result;
	}
	public int peek() {
		if (isempty()) {
			throw new EmptyStackException();
		}
		
	}
		
	
	
public static void main(String[] args)
{
	Stackelement  stack=new Stackelement ();
	stack.push(10);
	
}

}
