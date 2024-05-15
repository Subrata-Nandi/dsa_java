//1. Write a recursive function to calculate the gcd of two numbers.

package recursion;
public class Question1 {

	static int gcd(int n1, int n2) {
		if(n2 == 0)
			return n1;
		else
			return (gcd(n2,n1%n2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question1 obj = new Question1();
		System.out.println(obj.gcd(20, 30));
		System.out.println(obj.gcd(37, 36));
		System.out.println(obj.gcd(5, 100));
	}

}

/*
Output:

10
1
5
*/