/*
3. Write a recursive function to calculate the power of a two number(consider the degree as a
negative/positive integer).
*/

package recursion;

public class Question3 {

	static double power(double a, int b) {
		if(b==0)
			return 1;
		else if(b>0) 
			return (a * power(a, b-1));
		else 
			return ((1/a) * power(a, b+1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question3 obj = new Question3();
		System.out.println(obj.power(5, 3));
		System.out.println(obj.power(2, -3));
	}

}

/*
Output:

125.0
0.125
*/