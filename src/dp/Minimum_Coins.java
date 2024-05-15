/*
7. Write a program to find out the minimum no of coins to make change of given amount
For example, for N = 10 and S = {1,5,6,9}, there are two solutions: {5,5},{1,9} So output should
be 2. [Infinite Supply of coins]
*/

package dp;
import java.util.*;
public class Minimum_Coins {

	static int coins(int ind, int nums[], int T, int dp[][]) {
        if(ind == 0) {
            if(T % nums[0] == 0) return T/nums[0];
            return (int)1e9;
        }
        if(dp[ind][T] != -1) return dp[ind][T];

        int nonTake = coins(ind-1, nums, T, dp);
        int take = Integer.MAX_VALUE;

        if(nums[ind] <= T) {
            take = 1 + coins(ind, nums, T - nums[ind], dp);
        }
        return dp[ind][T] = Math.min(take, nonTake);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int S[] = {1,5,6,9};
		int target = 10;
//		int S[] = {2};
//		int target = 3;
		int dp[][] = new int[S.length][target + 1];
		
        for(int i[]: dp)
            Arrays.fill(i, -1);
        
        int ans = coins(S.length - 1, S, target, dp);
        
        if(ans >= 1e9) System.out.println("Minimum no. of coins required: -1");
        else System.out.println("Minimum no. of coins required: " + ans);
	}

}


/*
Output:

Minimum no. of coins required: 2

Minimum no. of coins required: -1

*/