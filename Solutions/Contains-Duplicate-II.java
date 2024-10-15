// https://leetcode.com/problems/contains-duplicate-ii

class ContainsDuplicateIISolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (k == 0){return false;}

        Set<Integer> slidingWindow = new HashSet<>(); 

        // Idea if to maintain only k integers and can check 

        for (int i = 0; i < nums.length; i++){
            if (slidingWindow.contains(nums[i])){
                return true; 
            }
            else if (i < k){
                slidingWindow.add(nums[i]);
            }
            else {
                slidingWindow.remove(nums[i - k]);
                slidingWindow.add(nums[i]);
            }
        }
        return false;    
    }
}