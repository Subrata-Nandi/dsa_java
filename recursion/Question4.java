/*
4. Write a recursive function to calculate the sum of 
all digits of a number entered by the user.
*/

package recursion;
import java.util.*;
public class Question4 {
	
	static int SumOfDigit(int n) {
		if(n==0)
			return 0;
		else
			return ((n%10) + SumOfDigit(n/10));
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		Question4 obj = new Question4();
		System.out.println("The sum of the digits are: " + obj.SumOfDigit(n));
	}
}

/*
Output:

Enter the number: 
134
The sum of the digits are: 8

Enter the number: 
205
The sum of the digits are: 7
*/