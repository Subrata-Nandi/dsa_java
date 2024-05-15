/*
2. Write a program to implement a queue using linked list, such that the operations
‘enqueue’ and ‘dequeue’ are performed in constant time.
*/

package circularLinkedList;

class Queue<T> {
	
	CNode<T> c1 = new CNode<T>();
	Queue() {}
	
	public void enqueue(T x) {
		c1.insert_at_end(x);
	}
	
	public T dequeue() {
		if(c1.getSize() == 0) {
			System.out.println("Queue is empty");
			return null;
		}
		T temp = c1.delete_at_front();
		return temp;
	}
	
}

public class MyQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q1 = new Queue<Integer>();
		q1.enqueue(10);
		q1.enqueue(2);
		q1.enqueue(3);
		q1.enqueue(4);
		q1.c1.display();
		System.out.println("Deleted element: " + q1.dequeue());
		System.out.println("Deleted element: " + q1.dequeue());
		System.out.println("Deleted element: " + q1.dequeue());
		System.out.println("Deleted element: " + q1.dequeue());
		System.out.println("Deleted element: " + q1.dequeue());
//		System.out.println(q1.c1.getSize());
		q1.enqueue(3);
		q1.enqueue(6);
//		System.out.println(q1.c1.getSize());
		System.out.println("Deleted element: " + q1.dequeue());
		System.out.println("Deleted element: " + q1.dequeue());
		
	}

}


/*

Output:

10 2 3 4 
Deleted element: 10
Deleted element: 2
Deleted element: 3
Deleted element: 4
Queue is empty
Deleted element: null
Deleted element: 3
Deleted element: 6


*/