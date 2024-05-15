//2. Write a recursive function to print the first n Fibonacci numbers.

package recursion;

public class Question2 {

	static int[] arr = new int[100];
	
	static int fibo(int n) {
		if(n<2) {
//			System.out.println(n);
			return n;
		}
//		if(arr[n]!=0) {
//			return arr[n];
//		}
		arr[n] = fibo(n-1) + fibo(n-2);
		return arr[n];
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question2 obj = new Question2();
		int n = 10;
		for(int i=0;i<n;i++) {
			System.out.print(fibo(i) + " ");
		}
	}

}

/*
Output:

0 1 1 2 3 5 8 13 21 34 
*/