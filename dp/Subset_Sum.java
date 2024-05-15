/*
8. Given a set of non-negative integers, and a value sum, Write a program to determine if there is a
subset of the given set with sum equal to given sum. Input: set [] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True [ There is a subset (4, 5) with sum 9]
*/

package dp;
import java.util.*;
public class Subset_Sum {

	static Boolean func(int ind, int a[], int sum, int dp[][]) {
        if(sum == 0) return true;
        if(ind == 0) return (a[0] == sum);
        
        if(dp[ind][sum] != -1) {
            return dp[ind][sum] == 0 ? false : true;
        }
        Boolean nonTake = func(ind-1, a, sum, dp);
        Boolean take = false;
        if(a[ind] <= sum) 
            take = func(ind-1, a, sum - a[ind], dp);
            
        dp[ind][sum] = nonTake || take ? 1 : 0;
        return take || nonTake;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		int dp[][] = new int[set.length][sum+1];
        for(int it[]: dp)
            Arrays.fill(it, -1);
        
        if(func(set.length-1, set, sum, dp)) 
        	System.out.println("True, there is a subset with sum " + sum);
        else
        	System.out.println("False, there is no subset with sum " + sum);
	}

}


/*
Output:

True, there is a subset with sum 9

False, there is no subset with sum 200

*/