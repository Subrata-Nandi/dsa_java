/*
2. Create a Class BasicSort within that implement three Generic methods that can implement the
BuubleSort(), SelectionSort(), InsertionSort() that can sort of any type of data.
*/

package array;
import java.util.*;

class BasicSort<T extends Comparable <T>> {
	
	void show(T arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	void bubbleSort(T arr[]) {		// Method for bubble sort
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			int swapped = 0;
			for(int j=0;j<n-i-1;j++) {
				if(arr[j].compareTo(arr[j+1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = 1;
				}
			}
			if(swapped == 0)		// If there is no swapping that means the elements are in correct order so break
				break;
		}
	}
	
	void selectionSort(T arr[]) {		// Method for selection sort
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			int mini = i;
			for(int j=i;j<n;j++) {
				if(arr[j].compareTo(arr[mini]) < 0)
					mini = j;		// Taking the index of minimum element
			}
			T temp = arr[mini];
			arr[mini] = arr[i];
			arr[i] = temp;
		}
	}
	
	void insertionSort(T arr[]) {		// Method for insertion sort
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int j = i;
			while(j>0 && arr[j-1].compareTo(arr[j]) > 0) {
				T temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
	}
}

public class Question2 {

	public static void main(String[] args) {
		Integer arr[] = new Integer[] {10,23,4,7,1};
		String arr1[] = new String[] {"Aman", "Rohan", "Piu", "Sun"};
		Double arr2[] = new Double[] {78.2, 23.4, 45.6, 12.4};
		BasicSort obj = new BasicSort();
		
		System.out.println("Sorting Integer data using Bubble Sort: ");
		obj.bubbleSort(arr);
		obj.show(arr);
		System.out.println("Sorting String data using Bubble Sort: ");
		obj.bubbleSort(arr1);
		obj.show(arr1);
		System.out.println("Sorting Double data using Bubble Sort: ");
		obj.bubbleSort(arr2);
		obj.show(arr2);
		
		System.out.println();
		System.out.println("Sorting Integer data using Selection Sort: ");
		obj.selectionSort(arr);
		obj.show(arr);
		System.out.println("Sorting String data using Selection Sort: ");
		obj.selectionSort(arr1);
		obj.show(arr1);
		System.out.println("Sorting Double data using Selection Sort: ");
		obj.selectionSort(arr2);
		obj.show(arr2);
		
		System.out.println();
		System.out.println("Sorting Integer data using Insertion Sort: ");
		obj.insertionSort(arr);
		obj.show(arr);
		System.out.println("Sorting String data using Insertion Sort: ");
		obj.insertionSort(arr1);
		obj.show(arr1);
		System.out.println("Sorting Double data using Insertion Sort: ");
		obj.insertionSort(arr2);
		obj.show(arr2);
	}

}

/*
Output:

Sorting Integer data using Bubble Sort: 
1 4 7 10 23 
Sorting String data using Bubble Sort: 
Aman Piu Rohan Sun 
Sorting Double data using Bubble Sort: 
12.4 23.4 45.6 78.2 

Sorting Integer data using Selection Sort: 
1 4 7 10 23 
Sorting String data using Selection Sort: 
Aman Piu Rohan Sun 
Sorting Double data using Selection Sort: 
12.4 23.4 45.6 78.2 

Sorting Integer data using Insertion Sort: 
1 4 7 10 23 
Sorting String data using Insertion Sort: 
Aman Piu Rohan Sun 
Sorting Double data using Insertion Sort: 
12.4 23.4 45.6 78.2 

*/