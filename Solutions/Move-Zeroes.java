// https://leetcode.com/problems/move-zeroes

class MoveZeroesSolution {
    public void moveZeroes(int[] nums) {

        int recentZero = 0;

        for (int j = 0; j < nums.length; j++){
            if (nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[recentZero];
                nums[recentZero] = temp; 
                recentZero += 1; 
            }
        }
        return;
    }
}