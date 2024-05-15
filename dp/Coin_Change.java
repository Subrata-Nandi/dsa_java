/*
6. Write a program to find out the total number of ways to make change of given amount.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1}, {1,1,2}, {2,2}, {1,3}.
So output should be 4. [Infinite Supply of coins]
*/

package dp;
import java.util.*;
public class Coin_Change {

	static long ways(int coins[], int ind, int T, long dp[][]) {
        if(ind == 0) {
            if(T % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[ind][T] != -1) return dp[ind][T];
        
        long nonTake = ways(coins, ind-1, T, dp);
        long take = 0;
        
        if(coins[ind] <= T) {
            take = ways(coins, ind, T - coins[ind], dp);
        }
        
        return dp[ind][T] = take + nonTake;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int S[] = {1,2,3};
		int sum = 4;
		long dp[][] = new long[S.length][sum+1];
        for(long arr[]: dp)
            Arrays.fill(arr, -1);

        System.out.println("Total number of ways to make change of given amount: " + ways(S, S.length - 1, sum, dp));
	}

}

/*
Output:

Total number of ways to make change of given amount: 4

*/