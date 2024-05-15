/*
5. Write a recursive function to find the sum of the following series.
(a) S= 2 + 4 + 6 + 8 + . . . . . + N (Input N).
(b) S= 1^2 - 3^2 + 5^2 - 7^2 + ..... + N (Input N).
(c) S = x^3 - x^3/3 + x^3/9 - x^3/27 + x^3/81 - x^3/243 .... (Input X, N)
*/


package recursion;

import java.util.*;
public class Question5 {

	static int Series1(int n) {
		if(n==1)
			return 2;
		else
			return((2*n) + Series1(n-1));
	}
	
	static int Series2(int n) {
		if(n==1)
			return 1;
		else
			return (int) (Math.pow(2*n-1, 2) * Math.pow(-1, n-1) + Series2(n-1));
	}
	
	static double Series3(int x, int n) {
		if(n==1)						
			return Math.pow(x, 3);
		else
			return (((Math.pow(x, 3) / Math.pow(3, n-1)) * Math.pow(-1, n-1)) + Series3(x, n-1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question5 obj = new Question5();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of terms for series: ");
		int n = sc.nextInt();		
		System.out.println("The sum of the digits of series 1 are: " + obj.Series1(n));
		System.out.println("The sum of the digits of series 2 are: " + obj.Series2(n));
		System.out.println("Enter the value of x: ");
		int x = sc.nextInt();
		System.out.println("Enter the number of terms for series 3: ");
		int m = sc.nextInt();
		System.out.println("The sum of the digits of series 3 are: " + obj.Series3(x, m));
	}

}


/*
Output:

Enter the number of terms for series: 
3
The sum of the digits of series 1 are: 12
The sum of the digits of series 2 are: 17
Enter the value of x: 
1
Enter the number of terms for series 3: 
4
The sum of the digits of series 3 are: 0.7407407407407409


Enter the number of terms for series: 
5
The sum of the digits of series 1 are: 30
The sum of the digits of series 2 are: 49
Enter the value of x: 
2
Enter the number of terms for series 3: 
4
The sum of the digits of series 3 are: 5.925925925925927

*/


