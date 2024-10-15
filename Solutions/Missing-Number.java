// https://leetcode.com/problems/missing-number

class MissingNumberSolution {
    public int missingNumber(int[] nums) {
        int total = 0; 

        for (int i = 0; i <= nums.length; i++){
            total ^= i;
        }

        for (int num : nums){
            total ^= num;
        }
        return total;
    }
}
