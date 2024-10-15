// https://leetcode.com/problems/house-robber

class HouseRobberSolution {
    public int rob(int[] nums) {

        // Recursive substructure: If we want to max profit for robbing n houses
        // We can either rob nth house and add it to all profit obtained up to n - 2, OR skip it and just take profit up to n - 1

        if (nums.length == 0){
            return 0;
        }
        else if (nums.length == 1){
            return nums[0];
        }
        

        int[] DP = new int[nums.length + 1]; // Here index i represents robbing i total houses 
        // Using the sturcture above, it actually gives all combos of ways to rob n houses, and we just take max of the summed values
        DP[0] = 0; 
        DP[1] = nums[0];

        for (int i = 2; i <= nums.length; i++){
            DP[i] = Math.max(nums[i - 1] + DP[i - 2], DP[i - 1]);
        }

        return DP[nums.length];
    }
}