
public class Queues {
int arr[],rear,front,count,capacity;
Queues(int size){
	arr=new int[size];
	capacity=size;
	rear=-1;
	front=0;
	count=0;
}


public int size() {
	return count;}


public boolean isEmpty() {
	return (size()==0);}


public boolean isFull() {
	return(size()==capacity);}


public void add(int data)
{
	if (isFull() ){
		System.out.println("queue is full");
	}
	else
	{
	System.out.println("inserting"+data);
	rear=(rear+1)%capacity;
	arr[rear]=data;
	count++;
	}
}


public void remove() {
	if(isEmpty()) {
		System.out.println("stack is empty");
	}
	else
	{
		System.out.println("removieng "+arr[front]);
		front=(front+1)%capacity;
		count--;
	}
}
public static void main(String[] args) {
	int n=5;
	Queues q=new Queues(n);
	q.add(44);
	q.add(54);
	q.add(64);
	q.remove();
	q.remove();
	q.remove();
	q.remove();
	//System.out.println(q;);
}
}
