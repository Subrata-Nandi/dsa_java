//7. Write a Program to reverse an array using a recursive function.

package recursion;

public class Question7 {
	
	static void reverseArray(int arr[], int lower, int upper) {
		if(lower>=upper)
			return;
		else {
			int temp = arr[lower];
			arr[lower] = arr[upper];
			arr[upper] = temp;
			reverseArray(arr, lower+1, upper-1);
		}
	}
	
	static void printArray(int arr[]) {
		System.out.println("The reverse of the array is: ");
		for(int i: arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question7 obj = new Question7();
		int arr[] = {1,2,3,4,5};
		int lower = 0;
		int upper = arr.length-1;
		obj.reverseArray(arr, lower, upper);
		obj.printArray(arr);
		
		int arr1[] = {1,2,3,4,5,6};
		int lower1 = 0;
		int upper1 = arr1.length-1;
		obj.reverseArray(arr1, lower1, upper1);
		obj.printArray(arr1);

	}

}

/*
Output:

The reverse of the array is: 
5 4 3 2 1 
The reverse of the array is: 
6 5 4 3 2 1 

*/