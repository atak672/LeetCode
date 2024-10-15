// https://leetcode.com/problems/climbing-stairs

class ClimbingStairsSolution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return tabulate(n, dp);
        
    }

    public int tabulate(int n, int[] dp){
        if (n == 0){
            return 1;
        }
        else if (n == 1){
            return 1; 
        }
        else if (dp[n] != 0){
            return dp[n];
        }

        return dp[n] = tabulate(n - 1, dp) + tabulate(n - 2, dp);
    }
}
