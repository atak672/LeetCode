// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated

class CheckIfArrayIsSortedAndRotatedSolution {
    public boolean check(int[] nums) {

       int drop = 0; 

        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                drop += 1; 
            }
        }

        if (nums[nums.length - 1] > nums[0]){
            drop += 1; 
        }
        return drop < 2;
    }
}