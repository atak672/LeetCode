// https://leetcode.com/problems/squares-of-a-sorted-array

class SquaresOfASortedArraySolution {
    public int[] sortedSquares(int[] nums) {

        int[] ret = new int[nums.length];

        int start = 0; 
        int end = nums.length - 1; 

        int i = end; 
        while (start <= end){
            if (Math.abs(nums[start]) >= Math.abs(nums[end])){
                ret[i] = nums[start] * nums[start]; 
                start += 1;
            }
            else {
                ret[i] = nums[end] * nums[end]; 
                end -= 1; 
            }
            i -= 1; 
        }   
        return ret; 
        
    }
}