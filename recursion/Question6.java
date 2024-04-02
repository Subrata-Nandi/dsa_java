//6. Write a Program to implement Binary Search using a recursive function.

package recursion;
import java.util.*;
public class Question6 {

	static int BinarySearch(int arr[], int element, int lower, int upper) {
		Arrays.sort(arr);
		int mid = 0;
		if(lower>=upper)
			return -1;
		else {
			mid = lower + (upper - lower) / 2;
			if(element > arr[mid]) 
				return BinarySearch(arr, element, mid+1, upper);
			else if(element < arr[mid])
				return BinarySearch(arr, element, lower, mid-1);
			else
				return mid;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question6 obj = new Question6();
		int arr[] = {10, 5, 6, 2, 33, 18};
		int element1 = 33;
		int element2 = 45;
		int lower = 0;
		int upper = arr.length;
		System.out.println("Element found at index: " + obj.BinarySearch(arr, element1, lower, upper));
		System.out.println("Element found at index: " + obj.BinarySearch(arr, element2, lower, upper));
	}

}

/*
Output:

Element found at index: 5
Element found at index: -1

*/