package sorting1;
import java.util.*;
class heap {
	int arr[] = new int[100];
	int size;
	
	public heap() {
		arr[0] = -1;
		size = 0;
	}
	
	public void insert(int element) {
		size = size + 1;
		int index = size;
		arr[index] = element;

		while(index > 1) {
			int parent = index / 2;
			if(arr[parent] < arr[index]) {
				int temp = arr[parent];
				arr[parent] = arr[index];
				arr[index] = temp;
				
				index = parent;
			}
			else {
				return;
			}
		}
	}
	
	public void delete() {
		if(size == 0) {
			System.out.println("Nothing to delete");
			return;
		}
		
		//step1: put last element into first index
		arr[1] = arr[size];
		
		//step2: remove last element
		size--;
		
		//step3: take root node to its correct position
		int i = 1;
		while(i < size) {
			int leftIndex = 2 * i;
			int rightIndex = 2 * i + 1;
			
			if(leftIndex < size && arr[i] < arr[leftIndex]) {
				int temp = arr[i];
				arr[i] = arr[leftIndex];
				arr[leftIndex] = temp;
				
				i = leftIndex;
			}
			else if(rightIndex < size && arr[i] < arr[rightIndex]) {
				int temp = arr[i];
				arr[i] = arr[rightIndex];
				arr[rightIndex] = temp;
				
				i = rightIndex;
			}
			else {
				return;
			}
		}
	}
	
	public void print() {
		for(int i=1;i<=size;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

public class HeapSort {

	public static void heapify(int arr[], int n, int i) {
		
		int largest = i;
		int left = 2 * i;
		int right = 2 * i + 1;
		
		if(left <= n && arr[largest] < arr[left]) {
			largest = left;
		}
		if(right <= n && arr[largest] < arr[right]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			heapify(arr, n, largest);
		}
	}
	
	public static void heapSort(int arr[], int n) {
		
		int size = n;
		int temp;
		
		while(size > 1) {
			// step1: swap
			temp = arr[size];
			arr[size] = arr[1];
			arr[1] = temp;
			
			size--;
			
			// step2
			heapify(arr, size, 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		heap h = new heap();
		h.insert(50);		// TC = O(log n)
		h.insert(55);
		h.insert(53);
		h.insert(52);
		h.insert(54);
		h.print();
		
		h.delete();		// TC = O(log n)
		h.print();
		
		int arr[] = {-1, 54, 53, 55, 52, 50};
		int n = arr.length - 1;
		
		// heap creation
		for(int i=n/2;i>0;i--) {
			heapify(arr, n, i);
		}
		System.out.println("Printing the array now: ");
		for(int i=1;i<=n;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// heap sort
		heapSort(arr, n);
		
		System.out.println("Printing the sorted array now: ");
		for(int i=1;i<=n;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
