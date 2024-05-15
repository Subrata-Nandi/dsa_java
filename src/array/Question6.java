/*
6. Write a program to find whether a matrix is orthogonal or not. Also find the 1-norm of the matrix.
 */

package array;

public class Question6 {

	static boolean isOrthogonal(int a[][], int m, int n) {		// Method to check if a matrix is orthogonal
		if(m!=n)
			return false;
		int transpose[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				transpose[i][j] = a[j][i];
			}
		}
		
		int product[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int sum = 0;
				for(int k=0;k<n;k++) {
					sum += a[i][k] * transpose[k][j];
				}
				product[i][j] = sum;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j && product[i][j] != 1)
					return false;
				if(i!=j && product[i][j] != 0)
					return false;
			}
		}
		return true;
	}
	
//	The 1-norm of a square matrix is the maximum of the absolute column sums.
	
	static int oneNorm(int a[][], int m, int n) {   // Method to compute 1-norm of a matrix
		int max = 0;
		for(int i=0;i<m;i++) {
			int sum = 0;
//			int k = 0;
			for(int j=0;j<n;j++) {
				sum += a[j][i];
			}
			if(sum>max)
				max=sum;
			
		}
		return max;
	}
	
	public static void main(String[] args) {
		
//		int mat[][] = {{1,0,0},		// To check orthogonal matrix
//				{0,1,0},
//				{0,0,1}
//		};
		
		int mat[][] = {{1,2,3},		 // To check 1-norm of a matrix
				{3,4,5},
				{9,6,7}
		};
		
		int row = mat.length;
		int col = mat[0].length;
		if(isOrthogonal(mat, row, col))
			System.out.println("It is a orthogonal matrix");
		else
			System.out.println("It is not a orthogonal matrix");
		
		System.out.println("The 1-norm of the matrix is: " + oneNorm(mat, row, col));
	}

}

/*
Output1:

It is not a orthogonal matrix
The 1-norm of the matrix is: 15

Output2:

It is a orthogonal matrix
The 1-norm of the matrix is: 1
*/