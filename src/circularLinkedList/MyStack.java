package circularLinkedList;

class Stack<T> {
	
	private int top;
	private int flag;
	CNode<T> c1 = new CNode<T>();
	Stack() {
		flag = 0;
	}
	
	public void push(T x) {
		if(flag == 0) {
			c1.create(x);
			flag = 1;
			return;
		}
		c1.insert_at_end(x);
	}
	
	public T pop() {
		if(c1.getSize() == 0) {
			System.out.println("Stack Underflow");
			return null;
		}
		T temp = c1.delete_at_end();
		return temp;
	}
	
}

public class MyStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		System.out.println("Popped element: " + s1.pop());
		System.out.println("Popped element: " + s1.pop());
		System.out.println("Popped element: " + s1.pop());
		System.out.println("Popped element: " + s1.pop());
		System.out.println("Popped element: " + s1.pop());
		s1.push(5);
		s1.push(6);
		System.out.println("Popped element: " + s1.pop());
		System.out.println("Popped element: " + s1.pop());
	}

}


/*

Output:

Popped element: 4
Popped element: 3
Popped element: 2
Popped element: 1
Stack Underflow
Popped element: null
Popped element: 6
Popped element: 5

*/