/*
5. Write a Class CheckTriangular within that implement methods to check whether a matrix is
i) Lower triangular ii) Upper triangular iii) Diagonal iv) Identity v) Tridiagonal.
 */

package array;

class CheckTriangular {
	void checkUpperTriangular(int a[][]) {
		boolean flag = true;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(i>j && a[i][j] != 0) {
					flag = false;
					break;
				}
			}
		}
		if(flag == false)
			System.out.println("It's not a upper triangular matrix.");
		else
			System.out.println("It's a upper triangular matrix.");
	}
	
	void checkLowerTriangular(int a[][]) {
		boolean flag = true;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(j>i && a[i][j] != 0) {
					flag = false;
					break;
				}
			}
		}
		if(flag == false)
			System.out.println("It's not a lower triangular matrix.");
		else
			System.out.println("It's a lower triangular matrix.");
	}
	
	void checkDiagonalMatrix(int a[][]) {
		boolean flag = true;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(i!=j && a[i][j] != 0) {
					flag = false;
					break;
				}
			}
		}
		if(flag == false)
			System.out.println("It's not a diagonal matrix.");
		else
			System.out.println("It's a diagonal matrix.");
	}
	
	void checkIdentityMatrix(int a[][]) {
		boolean flag = true;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {				
				if(i==j && a[i][j] != 1) {
					flag = false;
					break;
				}
				if(i!=j && a[i][j] != 0) {
					flag = false;
					break;
				}
			}
		}
		if(flag)
			System.out.println("It's a identity matrix.");
		else
			System.out.println("It's not a identity matrix.");
	}
	
	void checkTridiagonalMatrix(int a[][]) {
		boolean flag = true;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				int ele = a[i][j];
                if ((i==j) || (i-1==j) || (i+1==j)) {
                    if (ele == 0) {
                        flag = false;
                    }
                } else {
                    if (ele != 0) {
                        flag = false;
                    }
                }
			}
		}
		if(flag)
			System.out.println("It is a tridiagonal matrix");
		else
			System.out.println("It is not a tridiagonal matrix");
	}
}

public class Question5 {

	public static void main(String[] args) {
		
//		int mat[][] = { { 1, 0, 0, 0 },	// Lower triangular matrix checking
//                 { 1, 4, 0, 0 },
//                 { 4, 6, 2, 0 },
//                 { 0, 4, 7, 6 } };
		
//		int mat[][] = {{1,2,3}, 	// Upper triangular matrix checking
//				{0,4,5}, 
//				{0,0,6}};
		
//		int mat[][] = {{1,0,0}, 	// Diagonal matrix checking
//		{0,2,0}, 
//		{0,0,3}};
		
//		int mat[][] = {{1,0,0}, 	// Identity matrix checking
//		{0,1,0}, 
//		{0,0,1}};
		
		int mat[][] = {{1,2,0}, 	// Tridiagonal matrix checking
		{3,4,5}, 
		{0,6,7}};
		
		if(mat.length != mat[0].length) {
			System.out.println("Its not a square matrix.");
			System.exit(0);
		 }
		 CheckTriangular obj = new CheckTriangular();
//		 obj.checkUpperTriangular(mat);
//		 obj.checkLowerTriangular(mat);
//		 obj.checkDiagonalMatrix(mat);
//		 obj.checkIdentityMatrix(mat);
		 obj.checkTridiagonalMatrix(mat);
	}

}
