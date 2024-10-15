// https://leetcode.com/problems/search-in-rotated-sorted-array

class SearchInRotatedSortedArraySolution {
    public int search(int[] nums, int target) {

        int left = 0; 
        int right = nums.length - 1; 

        while (left <= right){
            int mid = left + ((right - left)/2);
             System.out.println(mid);

            if (nums[mid] == target){
                return mid; 
            }
            // For a pivot, mid splits it into [a, mid], [mid, b] -- one of which is SORTED
            
            // Left half is sorted
            if (nums[left] <= nums[mid]){

                if (nums[left] <= target && target <= nums[mid]){
                    // Search in left
                    right = mid - 1; 
                }
                else {
                    left = mid + 1; 
                }

            }

            // right half is sorted
            else {

                if (nums[mid] <= target && target <= nums[right]){
                    left = mid + 1; 
                }
                else {
                    right = mid - 1; 
                }

            }
        }
        return -1; 
    }
}