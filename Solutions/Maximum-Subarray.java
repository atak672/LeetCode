// https://leetcode.com/problems/maximum-subarray

class MaximumSubarraySolution {
    public int maxSubArray(int[] nums) {
        // Can do a sort of sliding window approach
        // If we extend it and meet a number that essentially cancels out our current sum (it zeroes out everything)
        // We can skip and start again, as no other subarray will be beneficial expanding from this current num
        int i = 0; 
        int j = 0; 
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0; 
        while (j < nums.length){
            currSum += nums[j];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0){
                i = j + 1; 
                j = i;
                currSum = 0; 
            }
            else {
                j += 1; 
            }
        }
        return maxSum;
    }
}