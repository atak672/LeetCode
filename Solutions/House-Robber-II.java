// https://leetcode.com/problems/house-robber-ii

class HouseRobberIISolution {
    public int rob(int[] nums) {

        // Edge cases: I am assuming we have at least 2 houses here
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        else if (n == 1){
            return nums[0];
        }

        // Two disjoint cases
        // 1. We rob the first house (and thus cant rob last)
        // Array shows max profit up to and maybe including house i -- houses labeled [0, n - 1]
        // We force robbing first house -- so max profit of robbing up to first 2 is just profit of 1
        int[] robFirst = new int[n];
        robFirst[0] = nums[0];
        robFirst[1] = nums[0];
        tabulate(nums, robFirst, n);

        // Here we do not rob the first house. Profit up to first house is 0. Profit up to 2nd is profit(2)
        int[] robLast = new int[n];
        robLast[0] = 0; 
        robLast[1] = nums[1];
        tabulate(nums, robLast, n);



        // Now remember, value in DP array is max profit up to and maybe including ith house
        // So for robFirst, we dont want to rob last house, so only check profit up until n - 2
        // For robLast, we do want to check profit up to and including last house possibly

        return Math.max(robLast[n - 1], robFirst[n - 2]);
        
    }

    // Bottom up tabulate appraoch 
    // Generates all combos for given conditions -- adapted from house robber I -- O(N)
    public void tabulate(int[] nums, int[] dp, int n){
        for (int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return;
    }
}
