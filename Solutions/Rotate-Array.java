// https://leetcode.com/problems/rotate-array

class RotateArraySolution {
    public void rotate(int[] nums, int k) {


        // First we will have 2 groups
        // We can first reverse the array to get things in correct position
        // Then for each group, we do a pairwise swap
        int n = nums.length;
        k %= n;


        swapNums(nums, 0, n- 1);
        swapNums(nums, 0, k - 1);
        swapNums(nums, k, n - 1);
        return;
    }

    public void swapNums(int[] nums, int left, int right){
         while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 1; 
            right -= 1; 
         }
         return;
    }
}