// https://leetcode.com/problems/3sum

class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>(); 

        // Cant check all pairs of 3
        // Need to keep one static -- sort 
        //Can keep i static, then check all other pairs that complete the triplet (add to 0)
        //This helps to minimize dupes inherently, say we have unique numbers, checking -1 would find 1 and 2 and would never be found again
        // Only problem is if we have dupes, need to check that i is a new number (i.e. arr[i] !+ arr[i - 1])
        // Other problem is duplicates in the non-fixed pointers
            // i.e. -1 1 1 2 2, will count -1, 2, 1 twice. Can use the fact that if we find some x + y + z = 0, we ensure the next x is unique. 
            // If we do the same for either y or z, then it forces the remaining number to be new. So make sure item at index start is new

        Arrays.sort(nums); 

        for (int i = 0; i < nums.length; i++){
            // Make sure we only fix unique i's 
            if (i != 0 && nums[i] == nums[i - 1]){
                continue; 
            }
            // Now it is basically a sorted two sum problem with a target equal to -1 * arr[i]
            int start = i + 1; 
            int end = nums.length - 1; 
            while (start < end){
                int num = nums[i] + nums[start] + nums[end];
                if (num == 0){
                    ret.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start += 1; 
                    while (start < end && nums[start] == nums[start - 1]){
                        start += 1; 
                    }
                    end -= 1; 
                }
                // Number is too big from target, need to shrink upper bound
                else if (num > 0) {
                    end -= 1; 
                }
                else {
                    // Too small, increase lower restriction 
                    // Make sure unique number
                    start += 1; 
                }
            }

        }
        return ret; 
    }
}