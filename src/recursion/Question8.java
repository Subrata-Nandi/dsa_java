// 8. Write a Program to calculate the length of the string using a recursive function.

package recursion;

public class Question8 {

	static int calculateLen(String s) {
		if(s.equals(""))
			return 0;
		else
			return (1 + calculateLen(s.substring(1)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question8 obj = new Question8();
		String s1 = "Hello World";
		String s2 = "The sky is blue";
		System.out.println("Length of the string: " + obj.calculateLen(s1));
		System.out.println("Length of the string: " + obj.calculateLen(s2));
	}

}

/*
Output:

Length of the string: 11
Length of the string: 15

*/