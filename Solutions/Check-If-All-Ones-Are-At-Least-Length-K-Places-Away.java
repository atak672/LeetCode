// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away

class CheckIfAllOnesAreAtLeastLengthKPlacesAwaySolution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        int i = 0; 
        
        while(nums[i] != 1){
            if (i == nums.length - 1){
                return true; 
            }
            i++;
            
        }
        
        for (int p = i + 1; p < nums.length; p++){
            if(nums[p] == 1){
                if (count < k){
                    return false; 
                }
                count = 0; 
                continue; 
            }
            count++;
        }
        return true;
    } 
}