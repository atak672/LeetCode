// https://leetcode.com/problems/k-diff-pairs-in-an-array

class KDiffPairsInAnArraySolution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ret = 0; 


        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++){
                if (i != j - 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if (k + nums[i] == nums[j]){
                    ret += 1; 
                }
            }
        }
        return ret;
    }
}