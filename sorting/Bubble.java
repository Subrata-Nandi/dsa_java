package sorting;

public class Bubble {
	static void bubble_sort(Integer arr[], int n) {
		for(int i=0;i<n-1;i++) {
			int swapped = 0;	// To check if there is any swapping
			for(int j=0;j<n-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = 1;
				}
			}
			
			if(swapped == 0) {		// If there is no swapping that means the elements are in correct order so break
				break;
			}
			
			for(int x=0;x<n;x++) {	// This part is done only to show the working mechanism of the bubble sort
				System.out.print(arr[x] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer arr[] = {13, 46, 24, 52, 20, 9};
//		Integer arr[] = {1,2,3,4,5,6};
		int n = arr.length;
		bubble_sort(arr, n);
		System.out.println("The sorted array using bubble sort: ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

/*
Output

13 24 46 20 9 52 
13 24 20 9 46 52 
13 20 9 24 46 52 
13 9 20 24 46 52 
9 13 20 24 46 52 
The sorted array using bubble sort: 
9 13 20 24 46 52 
*/

// ----------------------------------------------------------------------------------------------------------------------------------

/*
// Optimized java implementation of Bubble sort
 
import java.io.*;
 
class GFG {
     
    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                     
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
 
            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
 
    // Function to print an array
    static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver program
    public static void main(String args[])
    {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
*/