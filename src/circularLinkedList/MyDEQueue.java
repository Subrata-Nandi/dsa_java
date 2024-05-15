package circularLinkedList;
import java.util.*;
class DEQueue<T> {
	
	CNode<T> q = new CNode<T>();
	
	public void insert_rear(T n) {
		q.insert_at_end(n);
	}
	
	public void insert_front(T n) {
		q.insert_at_front(n);
	}
	
	public T delete_front() {
		if(q.getSize() == 0) {
			System.out.println("DEQueue is empty");
			return null;
		}
		T temp = q.delete_at_front();
		return temp;
	}
	
	public T delete_rear() {
		if(q.getSize() == 0) {
			System.out.println("DEQueue is empty");
			return null;
		}
		T temp = q.delete_at_end();
		return temp;
	}
	
	public void display() {
		q.display();
	}
}

public class MyDEQueue {

	public static void main(String[] args) {
		
		DEQueue<Integer> d = new DEQueue<Integer>();
/*
		 
		// Input restricted
		
		d.insert_rear(1);
		d.insert_rear(2);
		d.insert_rear(3);
		d.insert_rear(4);
		d.insert_rear(5);
		System.out.println("Deleted element: " + d.delete_front());
		System.out.println("Deleted element: " + d.delete_rear());
		System.out.println("Deleted element: " + d.delete_rear());
		d.display();
		System.out.println("Deleted element: " + d.delete_rear());
		System.out.println("Deleted element: " + d.delete_front());
		System.out.println("Deleted element: " + d.delete_rear());
		d.display();
		
*/
		
/*
		// Output restricted
		
		d.insert_front(1);
		d.insert_front(10);
		d.insert_rear(4);
		d.insert_rear(37);
		d.insert_front(22);
		d.display();
		System.out.println("Deleted element: " + d.delete_front());
		System.out.println("Deleted element: " + d.delete_front());
		System.out.println("Deleted element: " + d.delete_front());
		d.display();
		System.out.println("Deleted element: " + d.delete_front());
		System.out.println("Deleted element: " + d.delete_front());
		System.out.println("Deleted element: " + d.delete_front());
		d.insert_rear(55);
		d.insert_front(2);
		d.display();
		
*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		System.out.println("Enter 1 for input restricted queue 2 for output restricted queue: ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			while(true) {
				System.out.println("Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit");
				int ch = sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("Enter the element: ");
					int ele = sc.nextInt();
					d.insert_rear(ele);
					break;
				case 2:
					System.out.println("Deleted element: " + d.delete_rear());
					break;
				case 3:
					System.out.println("Deleted element: " + d.delete_front());
					break;
				case 4:
					d.display();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Invalid choice.");
				}
			}
		case 2:
			while(true) {
				System.out.println("Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit");
				int ch = sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("Enter the element: ");
					int ele = sc.nextInt();
					d.insert_rear(ele);
					break;
				case 2:
					System.out.println("Enter the element: ");
					int ele1 = sc.nextInt();
					d.insert_front(ele1);
					break;
				case 3:
					System.out.println("Deleted element: " + d.delete_front());
					break;
				case 4:
					d.display();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Invalid choice.");
				}
			}
		default:
			System.out.println("Invalid choice.");
		}
		
	}

}

/*

Output:

Enter your choice: 
Enter 1 for input restricted queue 2 for output restricted queue: 
1
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
1
Enter the element: 
1
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
1
Enter the element: 
2
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
1
Enter the element: 
3
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
1
Enter the element: 
4
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
1
Enter the element: 
5
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
4
1 2 3 4 5 
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
3
Deleted element: 1
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
2
Deleted element: 5
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
2
Deleted element: 4
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
4
2 3 
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
2
Deleted element: 3
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
3
Deleted element: 2
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
2
DEQueue is empty
Deleted element: null
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
1
Enter the element: 
33
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
1
Enter the element: 
7
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
4
33 7 
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
8
Invalid choice.
Enter 1.Insert rear 2.Delete rear 3.Delete front 4.Display 5.Exit
5



Enter your choice: 
Enter 1 for input restricted queue 2 for output restricted queue: 
2
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
2
Enter the element: 
1
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
2
Enter the element: 
2
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
1
Enter the element: 
34
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
1
Enter the element: 
76
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
2
Enter the element: 
5
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
4
5 2 1 34 76 
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
3
Deleted element: 5
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
3
Deleted element: 2
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
3
Deleted element: 1
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
4
34 76 
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
3
Deleted element: 34
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
3
Deleted element: 76
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
3
DEQueue is empty
Deleted element: null
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
7
Invalid choice.
Enter 1.Insert rear 2.Insert front 3.Delete front 4.Display 5.Exit
5

*/