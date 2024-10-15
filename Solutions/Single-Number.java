// https://leetcode.com/problems/single-number

class SingleNumberSolution {
    public int singleNumber(int[] nums) {
        int ret = 0; 
        for (int num : nums){
            ret ^= num; 
        }
        return ret; 
    }
}