// https://leetcode.com/problems/min-cost-climbing-stairs

class MinCostClimbingStairsSolution {
    public int minCostClimbingStairs(int[] cost) {

        // Stairs labeled [0, n - 1] where n = cost.length 
        // Can start at either stair 0 or 1 (can call these stairs 0 or 1 bc of index)
        // So to get to stair 2, we either step once from stair 1 or step twice from 0. We use its minCost to reach + cost of that stair
        // Lets say top of staircase is n

        // Cost of using stair i is cost[i]
        // Will use a DP array DP[i] where it stores minCost to get to that stair
        // So to find DP[n] = Math.min(cost[n - 1] + costToReach[n - 1], cost[n - 2] + costToReach(n - 2))


        int[] DP = new int[cost.length + 1]; // Allows n to be an index
        // Cost to start at stair 1 or 2 (index 0 or 1)
        DP[0] = 0; 
        DP[1] = 0; 
        
        for (int i = 2; i < DP.length; i++){
            DP[i] = Math.min(cost[i - 1] + DP[i - 1], cost[i - 2] + DP[i - 2]);
        }

        return DP[cost.length];
    }
}