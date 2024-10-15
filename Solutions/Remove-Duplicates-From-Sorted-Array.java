// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates(int[] nums) {

        // if (nums.length == 0){
        //     return 0; 
        // }

        int left = 0;
        int right = 0; 

        while (left <  nums.length && right < nums.length){
            if (nums[left] == nums[right]){
                right += 1; 
            }
            else {
                left += 1; 
                nums[left] = nums[right];
            }
        }

        return left + 1; 
    }
}





    //     if (nums.length == 0){
    //         return 0; 
    //     }

    //     int left = 0; 
    //     int right = 0; 

    //     while (left < nums.length - 1 && right < nums.length - 1){
    //         if (nums[left] == nums[right + 1]){
    //             right += 1; 
    //         }
    //         else{
    //             nums[left + 1] = nums[right+1];
    //             left += 1; 
    //         }
    //     }

    //     int k = 1; 
    //     for (int i = 0; i < nums.length - 1; i++){
    //         if (nums[i] < nums[i+1]){
    //             k += 1; 
    //         }
    //         else{
    //             break;
    //         }
    //     }

    //     return k; 
        
    // }
//}