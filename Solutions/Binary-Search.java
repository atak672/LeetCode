// https://leetcode.com/problems/binary-search

class BinarySearchSolution {
    public int search(int[] nums, int target) {

        // Can take advantage of binary search as array is sorted in ascending order
        // Can divide search space in half each time, eliminating excess iterations
        // Since we are dividing the search in half we can think of it as constant work + T(N/2) -- i.e. time it
        // Takes to do the rest of the operations on an array of half the size 
        // O(log(n))

        int start = 0; 
        int end = nums.length - 1; 


        while (start <= end){
            int mid = start + ((end - start)/2); // Trick to prevent overflow for large integer values
            if (nums[mid] == target){
                return mid; 
            }
            else if (nums[mid] >= target){
                end = mid - 1; 
            }
            else {
                start = mid + 1; 
            }
        }

        return -1; 
        
    }
}