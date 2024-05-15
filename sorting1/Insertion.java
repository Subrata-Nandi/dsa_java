/*
1. Write functions for each of the following sorting techniques (show the result after each
iteration)
b. Insertion
*/
package sorting1;
import java.util.*;
public class Insertion {

	static void insertion_sort(int arr[], int n) {
		int temp = 0;
		for(int i=0;i<n;i++) {
			int j = i;
			while(j>0 && arr[j-1] > arr[j]) {
				temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				
				j--;
			}
			print_arr(arr);
		}
	}
	
	static void print_arr(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		// 13 46 24 52 20 9
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		insertion_sort(arr, n);
		System.out.println("The sorted array is: ");
		print_arr(arr);
	}

}

/*

Output:

Enter the number of elements: 
6
Enter the elements: 
13 46 24 52 20 9
13 46 24 52 20 9 
13 46 24 52 20 9 
13 24 46 52 20 9 
13 24 46 52 20 9 
13 20 24 46 52 9 
9 13 20 24 46 52 
The sorted array is: 
9 13 20 24 46 52 


*/