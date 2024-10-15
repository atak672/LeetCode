// https://leetcode.com/problems/longest-consecutive-sequence

class LongestConsecutiveSequenceSolution {
    public int longestConsecutive(int[] nums) {

        // Can do this by using a set and taking a number as being the floor of a given range (val - 1 does not exist within set)
        // Need O(1) checking time -- set ofc 

        Set<Integer> set = new HashSet<>(nums.length); 
        for (int num : nums){
            set.add(num);
        }

        int max = 0; 

        for (int val : set){
           // int val = nums[i];
            if (set.contains(val - 1)){
                continue; 
            }

            int len = 0; 
            int temp = val; 
            while (set.contains(temp)){
                temp += 1; 
                len += 1; 
            }

            max = Math.max(len, max);
        }
        return max;
    }
}