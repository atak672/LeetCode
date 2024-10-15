// https://leetcode.com/problems/subarray-sum-equals-k

class SubarraySumEqualsKSolution {
    public int subarraySum(int[] nums, int k) {

        int[] prefix = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int count = 0; 

        // Essentially in prefix, looking for item where 

        // Can use a hashmap and solution similar to two sum to eval
        // If prefix[i] + target is in the hashmap, we can use O(1) access and one pass to find all associated values
        // We need to use the associated value to count the # of occurrences so if somethign is found, it pairs with all previous values

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefix.length; i++){
            int val = k + prefix[i];

            if (map.keySet().contains((prefix[i]))){
                count += map.get(val - k);
            }
            map.putIfAbsent(val, 0);
            map.put(val, map.get(val) + 1);
       }

       return count;
    }   
}