/*
2. Write a menu driven program to implement a doubly circular linked list with the
following operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
*/

package circularLinkedList;

class CNode<T> {
	private T data;
	private int size = 0;
	private CNode<T> head = null;
	private CNode<T> prev;
	private CNode<T> next;
	
	CNode() {}
	CNode(T n) {
		prev = null;
		data = n;
		next = null;
	}
	
	public void create(T n) {
		CNode<T> newNode = new CNode<T>(n);
		if(head == null) {
			head = newNode;
			newNode.prev = newNode;
			newNode.next = newNode;
			size++;
		}
		else {
			System.out.println("List already created");
		}
	}
	
	public void insert_at_front(T n) {
		if(head == null) {
			create(n);
		}
		else {
			CNode<T> p = head.prev;
			CNode<T> newNode = new CNode<T>(n);
			p.next = newNode;
			newNode.prev = p;
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size++;
		}
	}


	public void insert_at_end(T n) {
		if(head == null) {
			create(n);
		}
		else {
			CNode<T> p = head.prev;
			CNode<T> newNode = new CNode<T>(n);
			newNode.prev = p;
			newNode.next = head;
			p.next = newNode;
			head.prev = newNode;
			size++;
		}
	}
	
	public void insert_at_pos(int pos, T n) {
		CNode<T> p = head;
		int count = 1;
		if(pos == 1) {
			this.insert_at_front(n);
			return;
		}
		else if(pos == this.size+1) {
			this.insert_at_end(n);
			return;
		}
		else {
			if(p != null) {
				CNode<T> newNode = new CNode<T>(n);
				if(pos > size) {
					System.out.println("Position not found, so data cannot be inserted.");
					return;
				}
				while(count < pos-1) {
					p = p.next;
					count++;
				}	
				newNode.next = p.next;
				newNode.prev = p;
				p.next.prev = newNode;
				p.next = newNode;
				size++;
			}
			else {
				System.out.println("List is empty");
			}
		}
	}
	
	public T delete_at_front() {
		CNode<T> p = head.prev;
		T temp;
		if(p == null) {
			System.out.println("List is empty");
			return null;
		}
		else if(size == 1) {
			temp = head.data;
			head = null;
			size--;
			return temp;
		}
		else {
			temp = head.data;
			head = head.next;
			head.prev = p;
			p.next = head;
			size--;
			return temp;
		}

	}
	
	public T delete_at_end() {
		CNode<T> p = head.prev;
		T temp;
		if(p == null) {
			System.out.println("List is empty");
			return null;
		}
		else if(this.size == 1) {		
			temp = p.data;
			head = null;
			size--;
			return temp;
		}
		else {
			temp = p.data;
			p = p.prev;
			p.next = head;
			head.prev = p;
			size--;
			return temp;
		}
	}
	
	public void delete_at_pos(int pos) {
		if(pos == 1) {
			this.delete_at_front();
			return;
		}
		else if(pos == this.size) {
			this.delete_at_end();
			return;
		}
		else {
			CNode<T> p = head;
			CNode<T> t = p;
			int count = 1;
			if(p != null) {
				if(pos > size) {
					System.out.println("Position not found, so data cannot be inserted.");
					return;
				}
				else {
					while(count < pos) {
						t = p;
						p = p.next;
						count++;
					}
					p.next.prev = t;
					t.next = p.next;
//					p.next = p.next.next;		// This logic uses only single pointer p but you have to use while(count < pos-1)
//					p.next.prev = p;
					size--;
				}
			}
		}
	}
	
	public void display() {
		CNode<T> p = head;
		for(int i=0;i<this.size;i++) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	public int getSize() {
		return size;
	}
}

public class Question2b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CNode<Integer> cl = new CNode<Integer>();
		cl.create(1);
		cl.display();
		cl.insert_at_front(2);
		cl.display();
		cl.insert_at_end(3);
		cl.display();
		System.out.println("Size of circular double linked list: " + cl.getSize());
		cl.insert_at_pos(1, 4);
		cl.insert_at_pos(5, 10);
		cl.display();
		cl.insert_at_pos(3, 12);
		cl.display();
		System.out.println("Size of circular double linked list: " + cl.getSize());
		System.out.println("Deleted element: " + cl.delete_at_front());
		cl.display();
		System.out.println("Deleted element: " + cl.delete_at_end());
		cl.display();
		cl.delete_at_pos(3);
		cl.display();
		System.out.println("Size of circular double linked list: " + cl.getSize());
//		cl.insert_at_end(45);
//		cl.insert_at_end(32);
//		cl.display();
		cl.delete_at_front();
		cl.delete_at_front();
//		cl.display();
//		cl.delete_at_end();
		System.out.println("Hello");
		cl.delete_at_front();
//		cl.delete_at_front();
		cl.display();
		System.out.println("Size of circular double linked list: " + cl.getSize());
		cl.insert_at_front(1);
		cl.display();
		cl.insert_at_front(2);
		cl.display();
		System.out.println("Size of circular double linked list: " + cl.getSize());
	}

}

/*

Output

1 
2 1 
2 1 3 
Size of circular double linked list: 3
4 2 1 3 10 
4 2 12 1 3 10 
Size of circular double linked list: 6
Deleted element: 4
2 12 1 3 10 
Deleted element: 10
2 12 1 3 
2 12 3 
Size of circular double linked list: 3
3 

Size of circular double linked list: 0
1 
2 1 
Size of circular double linked list: 2




*/
