// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class FindMinimumInRotatedSortedArraySolution {
    public int findMin(int[] nums) {

        // We want to find the smallest number in log(n) time

        // Since the array was sorted, then rotated we can take advantage of sorted property
        // When we pick an arbitrary pivot, we can observe it splits the array into two halves, 
        // One of which is guaranteed to be sorted. Can take advantage of the fact this is sorted
        // See if value of either start or mid (arrays are either [start, mid] or [mid, end]) is min
        // We've seen so far, and keep going into non sorted half

        int min = Integer.MAX_VALUE; 
        int start = 0; 
        int end = nums.length - 1; 

        while (start <= end){
            int mid = start + ((end - start)/2);

            // Left half is sorted, start is lowest num possible in this half
            if (nums[start] <= nums[mid]){
                min = Math.min(nums[start], min);
                start = mid + 1; 
            }
            else if (nums[mid] <= nums[end]){
                // Mid is smallest number in sort
                min = Math.min(min, nums[mid]);
                // Look in left half
                end = mid - 1; 
            }
        }
        return min; 
    }
}