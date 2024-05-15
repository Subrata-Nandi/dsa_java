package sorting1;
import java.util.*;

class QS {
	
	public int func(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high;
		int temp = 0;
		
		while(i < j) {
			while(arr[i] <= pivot && i <= high - 1) {
				i++;
			}
			
			while(arr[j] > pivot && j >= low + 1) {
				j--;
			}
			
			if(i < j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;
		return j;
	}
	
	public void quickSort(int arr[], int low, int high) {
		if(low < high) {
			int partitionIndex = func(arr, low, high);
			quickSort(arr, low, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, high);
		}
	}
	
	public void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

public class Quick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QS obj = new QS();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of elements: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		// 4 6 2 5 7 9 1 3
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		obj.quickSort(arr, 0, n-1);
		System.out.println("The sorted elements are: ");
		obj.printArray(arr);
	}

}
