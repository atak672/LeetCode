// https://leetcode.com/problems/two-sum

class TwoSumSolution {

    //Caveates: 
        // 1). Here the order of the indexes dont matter, maybe they do sometimes, one in array
        //      will have lower ndex since it was already processed
        // 2). Any answer that adds up works, what if we wanted to return the first occurrence? (i.e. the lowest
        //      possible indices). For example, [4, 4, 6] target = 10 would return [1, 2] and not [0, 2]]


    public int[] twoSum(int[] nums, int target) {
        // Easiest way would be a simple O(n^2) iteration comparing all values
        // Could also do 2 passes over the array and store using a hashset
            //This means you do one pass and add and then do total - current and see if its in array
            // Be careful if the answer is the current # you're subtracting -- would need to check


        // The idea of this strategy is to do a one-pass over the array
        // And utilize the compliment of the number in question
        // For each integer in nums, check if its compliment has already been processed
        // i.e. is in the dictionary, if it is, return its value index 

        // Hashmap used for storage purposes -- O(1) access time
        HashMap<Integer, Integer> storage = new HashMap<>(); 
        
        // Iterate over each item in the original array nums
        for (int i = 0; i < nums.length; i++){

            // Calculate the compliment of the number -- the # necessary to find the answer
            int compliment = target - nums[i];

            // Essentially, if the compliment already exists in the hashmap, it was processed
            // and stored already, so it exists in nums. Return the compliments value (the index)
            // Since the indices should be in increasing order, the item already in the dictionary will have
            // have the lower index since it was already stored and processed. 
            if (storage.keySet().contains(compliment)){
                return new int[]{storage.get(compliment), i};
            }
            storage.put(nums[i], i);
        } 
        
       return new int[]{-1, -1}; 
        
    }
}