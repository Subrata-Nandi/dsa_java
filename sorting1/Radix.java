package sorting1;

class RadixSort {
	
	public int getMax(int arr[], int n) {
		int maxi = arr[0];
		for(int i=0;i<n;i++) {
			if(arr[i] > maxi)
				maxi = arr[i];
		}
		return maxi;
	}
	
	public void countSort(int arr[], int n, int pos) {
		int count[] = new int[n];
		int b[] = new int[n];

		for(int i=0;i<n;i++) {
			count[(arr[i]/pos)%10]++;
//			printArray(count);
		}

		for(int i=1;i<n;i++) {
			count[i] = count[i] + count[i-1];
//			printArray(count);
		}

		for(int i=n-1;i>=0;i--) {
//			b[count[(arr[i]/pos)%10] - 1] = arr[i];
//			count[(arr[i]/pos)%10]--;
			b[--count[(arr[i]/pos)%10]] = arr[i];
		}
			
		
		for(int i=0;i<n;i++)
			arr[i] = b[i];
	}
	
	public void radixSort(int arr[], int n) {
		int maxi = getMax(arr, n);
		for(int pos=1;(maxi/pos)>0;pos*=10) {
			countSort(arr, n, pos);
		}
	}
	
	public void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

public class Radix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadixSort obj = new RadixSort();
		int arr[] = {432, 8, 530, 90, 88, 231, 11, 45, 677, 199};
		obj.radixSort(arr, arr.length);
//		System.out.println(obj.getMax(arr, arr.length));
//		obj.countSort(arr, arr.length, 1);
		System.out.println("The sorted array is: ");
		obj.printArray(arr);
	}

}

/*

Output:

The sorted array is: 
8 11 45 88 90 199 231 432 530 677 

*/