/*
1. Write a menu driven program to implement a doubly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
*/

package doubleLinkedList;

class DNode<T> {
	private T data;
	private int size = 0;
	private DNode<T> head = null;
	private DNode<T> prev;
	private DNode<T> next;
	
	DNode() {}
	DNode(T n) {
		prev = null;
		data = n;
		next = null;
	}
	
	public void create(T n) {
		DNode<T> newNode = new DNode<T>(n);
		if(head == null) {
			head = newNode;
			size++;
		}
		else {
			System.out.println("List already created");
		}
	}
	
	public void insert_at_front(T n) {
		DNode<T> p = head;
		if(p == null) {
			create(n);
		}
		else {
			DNode<T> newNode = new DNode<T>(n);
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size++;
		}
	}
	
	public void insert_at_end(T n) {
		DNode<T> p = head;
		if(p == null) {
			create(n);
		}
		else {
			DNode<T> newNode = new DNode<T>(n);
			while(p.next != null) {
				p = p.next;
			}
			p.next = newNode;
			newNode.prev = p;
			size++;
		}
	}
	
	public void insert_at_pos(int pos, T n) {
		DNode<T> p = head;
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
				DNode<T> newNode = new DNode<T>(n);
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
	
	public void delete_at_front() {
		DNode<T> p = head;
		if(p == null) {
			System.out.println("List is empty");
		}
		else if(size==1) {
			head=null;
			size--;
		}
		else {
			head = head.next;
			head.prev = null;
			size--;
		}
	}
	
	public void delete_at_end() {
		DNode<T> p = head;
		DNode<T> t = p;
		if(p == null) {
			System.out.println("List is empty");
			return;
		}
		if(size == 1) {
			head = null;
			size--;
			return;
		}
		else {
			while(p.next != null) {
				t = p;
				p = p.next;
			}
			t.next = null;
			size--;
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
			DNode<T> p = head;
			DNode<T> t = p;
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
		DNode<T> p = head;
		while(p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	public int getSize() {
		return size;
	}
}

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DNode<Integer> dl = new DNode<Integer>();
		dl.create(1);
		dl.insert_at_front(2);
		dl.display();
		System.out.println("Size of double linked list: " + dl.getSize());
		dl.insert_at_end(5);
		dl.insert_at_end(7);
		dl.display();
		System.out.println("Size of double linked list: " + dl.getSize());
		dl.insert_at_pos(1, 10);
		dl.display();
		dl.insert_at_pos(3, 17);
		dl.display();
		dl.insert_at_pos(7, 15);
		dl.display();
		System.out.println("Size of double linked list: " + dl.getSize());
		dl.delete_at_front();
		dl.display();
		dl.delete_at_end();
		dl.display();
		System.out.println("Size of double linked list: " + dl.getSize());
//		dl.delete_at_pos(1);
//		dl.display();
//		dl.delete_at_pos(4);
//		dl.display();
//		dl.delete_at_pos(2);
//		dl.display();
		dl.delete_at_end();
		dl.delete_at_end();
		dl.display();
		dl.delete_at_front();
		dl.delete_at_front();
		dl.delete_at_front();
		dl.display();
		dl.insert_at_end(20);
		dl.insert_at_front(23);
		dl.insert_at_pos(2, 5);
		dl.display();
		dl.delete_at_pos(2);
		dl.display();
		System.out.println("Size of double linked list: " + dl.getSize());
	}

}


/*

Output

2 1 
Size of double linked list: 2
2 1 5 7 
Size of double linked list: 4
10 2 1 5 7 
10 2 17 1 5 7 
10 2 17 1 5 7 15 
Size of double linked list: 7
2 17 1 5 7 15 
2 17 1 5 7 
Size of double linked list: 5
2 17 1 

23 5 20 
23 20 
Size of double linked list: 2



*/
