package recursion;

public class TowerOfHanoi {
	
	static void towerOfHanoi(int n, char S, char D, char A) {
		if(n == 0)
			return;
		
		towerOfHanoi(n-1, S, A, D);
		System.out.println("Moving disk " + n + " from " + S + " to " + D);
		towerOfHanoi(n-1, A, D, S);
	}
	
	public static void main(String args[]) {
		towerOfHanoi(3, 'A', 'C', 'B');
	}
}
