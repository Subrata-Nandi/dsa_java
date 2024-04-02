package sorting;

public class Insertion {
	static void insertion_sort(Integer arr[], int n) {
		for(int i=0;i<n;i++) {
			int j = i;
			while(j>0 && arr[j-1]>arr[j]) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				
				j--;
//				System.out.println("Runs");
			}
			
			
//			for(int x=0;x<n;x++) {	// This part is done only to show the working mechanism of the insertion sort
//				System.out.print(arr[x] + " ");
//			}
//			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer arr[] = {13, 46, 24, 52, 20, 9};
//		Integer arr[] = {1,2,3,4,5,6};
		int n = arr.length;
		insertion_sort(arr, n);
		System.out.println("The sorted array using insertion sort: ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

/*
Output

13 46 24 52 20 9 
13 46 24 52 20 9 
13 24 46 52 20 9 
13 24 46 52 20 9 
13 20 24 46 52 9 
9 13 20 24 46 52 
The sorted array using insertion sort: 
9 13 20 24 46 52 
*/