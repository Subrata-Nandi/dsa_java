package dp;

public class Knapsack_01 {

	static int knapSackCalculate(int W, int wt[], int val[], int ind, int dp[][]) {
        if(ind == 0) {
            if(wt[0] <= W) return val[0];
            else return 0;
        }
        
        if(dp[ind][W] != -1) return dp[ind][W];
        
        int nonTake = 0 + knapSackCalculate(W, wt, val, ind-1, dp);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W)
            take = val[ind] + knapSackCalculate(W - wt[ind], wt, val, ind-1, dp);
        
        dp[ind][W] = Math.max(nonTake, take);
        return dp[ind][W];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wt[] = {3, 4, 5};
		int val[] = {30, 50, 60};
		int n = wt.length;
		int W = 8;
		
		int dp[][] = new int[n][W+1];
        for(int i=0;i<n;i++) {
            for(int j=0;j<=W;j++) {
                dp[i][j] = -1;
            }
        }
        
        System.out.println("Maximum value that can be added in knapsack: " + knapSackCalculate(W, wt, val, n-1, dp));
	}

}

/*
Output:

Maximum value that can be added in knapsack: 90

*/