package sorting1;
import java.util.*;

class MS {
	
	public void merge(int arr[], int low, int mid, int high) {
		int left = low;
		int right = mid + 1;
		ArrayList<Integer> temp = new ArrayList<>();
		while(left <= mid && right <= high) {
			if(arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			}
			else {
				temp.add(arr[right]);
				right++;
			}
		}
		
		while(left <= mid) {
			temp.add(arr[left]);
			left++;
		}
		
		while(right <= high) {
			temp.add(arr[right]);
			right++;
		}
		
		for(int i=low;i<=high;i++) {
			arr[i] = temp.get(i - low);
		}
	}
 	
	public void mergeSort(int arr[], int low, int high) {
		if(low >= high)
			return;
		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}
	
	public void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

public class Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {6,5,4,3,2,1};
		int arr1[] = {19, -3, 7, -56, 100, -2};
		MS obj = new MS();
		obj.mergeSort(arr, 0, arr.length-1);
		obj.printArray(arr);
		obj.mergeSort(arr1, 0, arr1.length-1);
		obj.printArray(arr1);
	}

}

/*

Output:

1 2 3 4 5 6 
-56 -3 -2 7 19 100 

*/