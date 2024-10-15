// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k

class MaximumSizeSubarraySumEqualsKSolution {
    public int maxSubArrayLen(int[] nums, int k) {
        // Sums over a continuous area

        // Idea -- we are essentially looking for a sum over sum fixed array area
        // Can essentially compute a prefix array s.t. index 0 has all values [beginning, i)
        // If you want value up to and including idx i index [i + 1]
        // some array subset [i, j] has the sum arr[j + 1] - arr[i] and length j + 1 - i
        // Can treat this like a two sum problem, for a given subarray that starts at arr i to have a total sum k
            // Some other index j must have prefix value k + arr[i]. Anf for this problem, we want to maximize j+ 1 - 1 for the answer


        // Step One: Compute prefix array
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i - 1] + nums[i-1];
        }

        Map<Integer, Integer> map = new HashMap<>(); 
        int maxLength = 0; 
        for (int i = 0; i < prefix.length; i++){
            if (map.keySet().contains(prefix[i])){
                maxLength = Math.max(maxLength, i - map.get(prefix[i]));
            }
            int val = k + prefix[i];
            map.putIfAbsent(val, i);
        }
        return maxLength;
    }
}