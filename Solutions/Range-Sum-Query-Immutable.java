// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {

    int[] ret; 

    public NumArray(int[] nums) {

        this.ret = new int[nums.length + 1];
        // ret[i] wll be sum of values up to but not including i
        // So ret[0] will be 0 ofc
        for (int i = 0; i < nums.length; i++){
            ret[i + 1] = ret[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {

        return ret[right + 1] - ret[left];
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */