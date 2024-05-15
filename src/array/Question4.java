/*
Write class SparseMatrix to give a compressed storage representation of a sparse matrix and
also find the transpose of the sparse matrix (from the compressed representation).
*/

package array;

import java.util.Arrays;
import java.util.Comparator;

class SparseMatrix {
	
	void ReducedMatrix(int a[][]) {
		int element = 0;
		int n=a.length;
		int m=a[0].length;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] != 0) {
					element++;
				}
			}
		}
		
		if(element*3>=n*m) {
			System.out.println("there's no benifit to convert this matrix into sparse compressed form");
			System.out.println("returning the given matrix");
		}
		else {
			int k = 0;
			int reducedMatrix[][] = new int[element][3];
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a[i].length;j++) {
					if(a[i][j] != 0) {
						reducedMatrix[k][0] = i;
						reducedMatrix[k][1] = j;
						reducedMatrix[k][2] = a[i][j];
						k++;
					}
				}
			}
			System.out.println("Reduced representation of the sparse matrix: ");
			display(reducedMatrix);
			transpose(reducedMatrix);
		}
		
		
		
//		System.out.println("Row\tColumn\tValue");
//		for(int i=0;i<element;i++) {
//			for(int j=0;j<3;j++) {
//				System.out.print(reducedMatrix[i][j] + "\t");
//			}
//			System.out.println();
//		}
		
		
	}
	
	void display(int arr[][]) {
		System.out.println("Row\tColumn\tValue");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i][0]+"\t"+arr[i][1]+"\t"+arr[i][2]);
		}
		System.out.println();
	}
	
	void transpose(int a[][]) {
		Arrays.sort(a, Comparator.comparingInt(column -> column[1]));
		for(int i=0;i<a.length;i++) {
			int temp = a[i][0];
			a[i][0] = a[i][1];
			a[i][1] = temp;
		}
		System.out.println("Transpose of the sparse matrix: ");
		display(a);
	}
}

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{0, 0, 0, 5}, 
				{0, 2, 0, 0}, 
				{0, 4, 1, 0}, 
				{7, 0, 0, 0}
		};
		SparseMatrix obj = new SparseMatrix();
		obj.ReducedMatrix(arr);
	}

}


/*
Output

Reduced representation of the sparse matrix: 
Row		Column	Value
0		3		5
1		1		2
2		1		4
2		2		1
3		0		7

Transpose of the sparse matrix: 
Row		Column	Value
0		3		7
1		1		2
1		2		4
2		2		1
3		0		5

*/