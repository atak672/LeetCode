// https://leetcode.com/problems/number-of-good-pairs

class NumberOfGoodPairsSolution {
    public int numIdenticalPairs(int[] nums) {
        int total = 0; 
        
        // Optimize to do one pass over nums array
        // Can use array to improve space

       int[] pairs = new int[101];

        for (int num : nums){

            // If encountering number for the first time -- no valid pairs
          pairs[num] += 1; 
        }

        for (int i : pairs){
            total += (i * (i-1))/2;
        }
       
       return total;
    }
}