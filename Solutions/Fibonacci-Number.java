// https://leetcode.com/problems/fibonacci-number

class FibonacciNumberSolution {
    public int fib(int n) {
        int[] dp = new int[n + 1];

        return dp(n, dp);
        
    }

    public int dp(int n, int[] DP){
        if (n == 0){
            return 0; 
        }
        else if (n == 1){
            return 1; 
        }
        else if (DP[n] != 0){
            return DP[n];
        }
        
    
        DP[n] = dp(n - 1, DP) + dp(n - 2, DP);
        return DP[n];
    }
}