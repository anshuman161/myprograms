
public class Queuethroughlinkedlist {
	QNode front,rear;
	Queuethroughlinkedlist(){
		this.front=this.rear=null;
	}
	
	
	
	class QNode{
		int key; 
		QNode next;
		public QNode(int key) {
			this.key=key;
			this.next=null;
		}
	}

	
	void add(int key) {
	QNode temp=new QNode(key);
	if(this.rear==null) {
		this.front=this.rear=temp;
		return;
	}
	this.rear.next=temp;
	this.rear=temp;
	}
	
	
	void remove() {
		if(this.front==null)
		{
			return ;
		}
		QNode temp=this.front;
		this.front=this.front.next;
		if(this.front==null) {
			this.rear=null;
			
		}
	}
	public static void main(String[] args) {
		Queuethroughlinkedlist q=new Queuethroughlinkedlist();
		q.add(10);
	}
}
