package sorting;

public class Selection {
	
	static void selection_sort(Integer arr[], int n) {
		for(int i=0;i<n-1;i++) {
			int mini = i;
			for(int j=i;j<n;j++) {
				if(arr[j] < arr[mini])
					mini = j;
			}
			int temp = arr[mini];
			arr[mini] = arr[i];
			arr[i] = temp;
			
//			for(int x=0;x<n;x++) {	// This part is done only to show the working mechanism of the selection sort
//				System.out.print(arr[x] + " ");
//			}
//			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer arr[] = {13, 46, 24, 52, 20, 9};
		int n = arr.length;
		selection_sort(arr, n);
		System.out.println("The sorted array using selection sort: ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}

}

/*
Output

9 46 24 52 20 13 
9 13 24 52 20 46 
9 13 20 52 24 46 
9 13 20 24 52 46 
9 13 20 24 46 52 
The sorted array using selection sort: 
9 13 20 24 46 52 
*/