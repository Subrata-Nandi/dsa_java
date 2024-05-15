/*
1. Create a Class Search within that implement two Generic method LinearSearch(),
BinarySearch(). Test your program for different data.
*/
package array;
import java.util.*;
/*
class Search {
	void linearSearch(int arr[], int ele) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == ele) {
				System.out.println("Element found at index " + (i+1));
				count += 1;
				break;
			}			
		}
		if(count == 0) 
			System.out.println("Element not found.");
	}
	
	int binarySearch(int arr[], int ele) {
		Arrays.sort(arr);
		int l,u,mid;
		l = 0;
		u = arr.length - 1;
		while(l<=u) {
			mid = (l+u)/2;
			if(ele > arr[mid]) {
				l = mid + 1;
			}
			else if(ele < arr[mid]) {
				u = mid - 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}

public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enter the element: ");
			arr[i] = sc.nextInt();
		}
		System.out.println("The actual array is: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("Enter the element to search: ");
		int ele = sc.nextInt();
		
		Search obj = new Search();
//		obj.linearSearch(arr, ele);
		
		int result = obj.binarySearch(arr, ele);
		if(result == -1)
			System.out.println("Element not found.");
		else
			System.out.println("Element found at index " + (result+1));
	}

}
*/

//---------------------------------------------------------------------------------------------------------------------------

class Search<T extends Comparable <T>> {
	void linearSearch(T arr[], T ele) {			// Linear search method
		System.out.println("Searching done using Linear Search method: ");
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].compareTo(ele) == 0) {
				System.out.println("Element found at index " + (i+1));		// Print index if target found
				count += 1;
				break;
			}			
		}
		if(count == 0) 
			System.out.println("Element not found.");
	}
	
	int binarySearch(T arr[], T ele) {			// Binary search method
		System.out.println("Searching done using Binary Search method: ");
		Arrays.sort(arr);
		int l,r,mid;
		l = 0;
		r = arr.length - 1;
		while(l<=r) {
			mid = l+(r-l)/2;
			int cmp = ele.compareTo(arr[mid]);
			if(cmp > 0) {		// Search right half
				l = mid + 1;
			}
			else if(cmp < 0) {		// Search left half
				r = mid - 1;	
			}
			else {		// Return index if target found
				return mid;
			}
		}
		return -1;		// Return -1 if target not found
	}
}

public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Searching for integer elements: ");
		Integer arr[] = {10,34,22,1,5};
		Search<Integer> obj = new Search<Integer>();		// Creating object of Integer type
		obj.linearSearch(arr, 22);
		int result = obj.binarySearch(arr, 40);
		if(result == -1)
			System.out.println("Element not found.");
		else
			System.out.println("Element found.");
		
		
		System.out.println("Searching for string elements: ");
		String arr1[] = {"Aman", "Rohan", "Piu", "Sun"};
		String ele1 = "Mobius";
		Search<String> obj1 = new Search<String>();			// Creating object of String type
		obj1.linearSearch(arr1, ele1);
		int result1 = obj1.binarySearch(arr1, ele1);
		if(result1 == -1)
			System.out.println("Element not found.");
		else
			System.out.println("Element found.");
		
		System.out.println("Searching for floating elements: ");
		Double arr2[] = {12.3, 45.6, 6.9, 2.4, 3.8};
		Double ele2 = 5.4;
		Search<Double> obj2 = new Search<Double>();			// Creating object of Double type
		obj2.linearSearch(arr2, ele2);
		int result2 = obj2.binarySearch(arr2, ele2);
		if(result2 == -1)
			System.out.println("Element not found.");
		else
			System.out.println("Element found.");
	}

}

/*
Output 1:

Searching for integer elements: 
Searching done using Linear Search method: 
Element found at index 3
Searching done using Binary Search method: 
Element found.
Searching for string elements: 
Searching done using Linear Search method: 
Element found at index 2
Searching done using Binary Search method: 
Element found.
Searching for floating elements: 
Searching done using Linear Search method: 
Element found at index 4
Searching done using Binary Search method: 
Element found.

Output 2:

Searching for integer elements: 
Searching done using Linear Search method: 
Element found at index 3
Searching done using Binary Search method: 
Element not found.
Searching for string elements: 
Searching done using Linear Search method: 
Element not found.
Searching done using Binary Search method: 
Element not found.
Searching for floating elements: 
Searching done using Linear Search method: 
Element not found.
Searching done using Binary Search method: 
Element not found.

*/