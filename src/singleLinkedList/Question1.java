/*
Singly Linked List
1. Write a menu driven program to implement a singly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists
*/

package singleLinkedList;

class Node<T> {
	private T data;
	private int size = 0;
	private Node<T> next;
	private Node<T> head = null;
	Node() {}
	Node(T n) {
		data = n;
		next = null;
	}
	
	public void create(T n) {
		Node<T> newNode = new Node<T>(n);
		if(head == null) {		
			head = newNode;
			size++;
		}
		else {
			System.out.println("List already created");
		}
	}
	
	public void insert_end(T n) {
		Node<T> p = head;
		if(p == null)
			this.create(n);
		else {
			Node<T> newNode = new Node<T>(n);
			while(p.next != null)
				p = p.next;
			p.next = newNode;
			size++;
		}
	}
	
	public void insert_beg(T n) {
		Node<T> p = head;
		if(p == null) 
			this.create(n);
		else {
			Node<T> newNode = new Node<T>(n);
			newNode.next = p;
			head = newNode;
			size++;
		}
	}
	
	public void insert_any_pos(int pos, T n) {
		Node<T> p = head;
		int count = 1;
		if(pos == 1) {
			this.insert_beg(n);
			return;
		}
		else if(pos == this.size+1) {
			this.insert_end(n);
			return;
		}
		else {
			if(p != null) {
				Node<T> newNode = new Node<T>(n);
				if(pos > size) {
					System.out.println("Position not found, so data cannot be inserted.");
					return;
				}
				while(count < pos-1) {
					p = p.next;
					count++;
				}	
				newNode.next = p.next;
				p.next = newNode;
				size++;
			}
			else {
				System.out.println("List is empty");
			}
		}
	}
	
	public void delete_beg() {
		Node<T> p = head;
		if(p == null) {
			System.out.println("List is empty");
		}
		else {
			head = head.next;
			size--;
		}
	}
	
	public void delete_end() {
//		Node<T> p = head;
//		Node<T> t = p;
//		if(p == null) {
//			System.out.println("List is empty");
//		}
//		else {
//			while(p.next != null) {
//				t = p;
//				p = p.next;
//			}
//			t.next = null;
//			size--;
//		}
		Node <T> curr=head;
		//1 
		//c
		if(curr == null) {
			System.out.println("List is empty");
			return;
		}
		if(size==1) {
			head=null;
			size--;
			return;
		}
		while(curr.next.next!=null) {
			curr=curr.next;
		}
		curr.next=null;
		size--;
		
	}
	
	public void delete_any_pos(int pos) {
		if(pos == 1) {
			this.delete_beg();
			return;
		}
		else if(pos == this.size) {
			this.delete_end();
			return;
		}
		else {
			Node<T> p = head;
			Node<T> t = p;
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
					t.next = p.next;
					size--;
				}
			}
			else {
				System.out.println("List is empty");
			}
		}
	}
	
	public void linearSearch(T ele) {
		Node<T> p = head;
		int pos = 1;
		if(p == null) {
			System.out.println("List is empty");
		}
		else {
			int count = 0;
			while(p != null) {
				if(p.data == ele) {
					System.out.println("Element found");
					count++;
					break;
				}
				p = p.next;
				pos++;
			}
			if(count == 0) {
				System.out.println("Element not found");
			}
		}
	}
	
	public void insert_after_specified_element(T target, T ele) {
		Node<T> p = head;
		int pos = 1;
		if(p == null) {
			System.out.println("List is empty");
		}
		else {
			int count = 0;
			while(p != null) {
				if(p.data == target) {
					insert_any_pos(pos, ele);
					count++;
					break;
				}
				p = p.next;
				pos++;
			}
			if(count == 0) {
				System.out.println("Element not found");
			}
			
		}
	}
	
	public void delete_specified_element(T ele) {
		Node<T> p = head;
		int pos = 1;
		if(p == null) {
			System.out.println("List is empty");
		}
		else {
			int count = 0;
			while(p != null) {
				if(p.data == ele) {
					delete_any_pos(pos);
					count++;
					break;
				}
				p = p.next;
				pos++;
			}
			if(count == 0) {
				System.out.println("Element not found");
			}
			
		}
	}
	
	public void reverse() {
		Node<T> curr = head;
		Node<T> prev = null;
		Node<T> next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public void concatenate(Node<T> list) {
		Node<T> p = this.head;
		while(p.next != null) {
			p = p.next;
		}
		p.next = list.head;
		this.size += list.size;
	}
	
	public void display() {
		Node<T> p = head;
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


public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> l1 = new Node<Integer>();
		l1.create(1);
		l1.insert_end(2);
		l1.insert_end(3);
		l1.display();
		l1.insert_beg(7);
		l1.insert_beg(5);
		l1.display();
		l1.insert_any_pos(1, 10);
		l1.display();
		l1.insert_any_pos(3, 11);
		l1.display();
		l1.insert_any_pos(10, 20);
		l1.insert_any_pos(7, 23);
		l1.insert_any_pos(9, 33);
		l1.display();
		System.out.println("Size of linked list: " + l1.getSize());
		l1.delete_beg();
		l1.display();
		l1.delete_end();
		l1.display();
		l1.delete_any_pos(3);
		l1.display();
		System.out.println("Size of linked list: " + l1.getSize());
		l1.linearSearch(3);
		l1.linearSearch(10);
		l1.insert_after_specified_element(1, 20);
		l1.display();
		System.out.println("Size of linked list: " + l1.getSize());
		l1.delete_specified_element(24);
		l1.delete_specified_element(3);
		l1.display();
		System.out.println("Size of linked list: " + l1.getSize());
		l1.reverse();
		l1.display();
		
		
		Node<Integer> l2 = new Node<Integer>();
		l2.create(11);
		l2.insert_end(22);
		l2.insert_beg(35);
		l2.insert_any_pos(4, 55);
		l2.display();
		l2.delete_beg();
		l2.delete_beg();
//		l2.delete_beg();
//		l2.delete_beg();
		l2.delete_end();
		l2.delete_end();
		l2.insert_beg(10);
		l2.insert_end(20);
		l2.display();
//		System.out.println("Hello");
		
		l1.concatenate(l2);
		l1.display();
		System.out.println("Size of linked list: " + l1.getSize());
	}

}


/*

Output

1 2 3 
5 7 1 2 3 
10 5 7 1 2 3 
10 5 11 7 1 2 3 
Position not found, so data cannot be inserted.
10 5 11 7 1 2 23 3 33 
Size of linked list: 9
5 11 7 1 2 23 3 33 
5 11 7 1 2 23 3 
5 11 1 2 23 3 
Size of linked list: 6
Element found
Element not found
5 11 20 1 2 23 3 
Size of linked list: 7
Element not found
5 11 20 1 2 23 
Size of linked list: 6
23 2 1 20 11 5 
35 11 22 55 
10 20 
23 2 1 20 11 5 10 20 
Size of linked list: 8


*/