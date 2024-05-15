/*
1. Write functions to implement a solution to Towers of Hanoi problem. Check your
program with number of disks = 0, 1, 2 and 3.

Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks. Initially, all the disks are stacked in decreasing value of diameter i.e., the smallest disk is placed on the top and they are on rod A. The objective of the puzzle is to move the entire stack to another rod (here considered C), obeying the following simple rules: 

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
No disk may be placed on top of a smaller disk.
*/

package recursion_tree;

public class TowerOfHanoi {
	
	static void towerOfHanoi(int n, char S, char D, char A) {
		if(n == 0)
			return;
		
		towerOfHanoi(n-1, S, A, D);
		System.out.println("Moving disk " + n + " from " + S + " to " + D);
		towerOfHanoi(n-1, A, D, S);
	}
	
	public static void main(String args[]) {
		towerOfHanoi(4, 'A', 'C', 'B');
	}
}


/*
Output

Moving disk 1 from A to B
Moving disk 2 from A to C
Moving disk 1 from B to C
Moving disk 3 from A to B
Moving disk 1 from C to A
Moving disk 2 from C to B
Moving disk 1 from A to B
Moving disk 4 from A to C
Moving disk 1 from B to C
Moving disk 2 from B to A
Moving disk 1 from C to A
Moving disk 3 from B to C
Moving disk 1 from A to B
Moving disk 2 from A to C
Moving disk 1 from B to C

*/