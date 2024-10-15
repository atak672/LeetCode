// https://leetcode.com/problems/combination-sum-ii

class CombinationSumIISolution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);

        combosumHelper(candidates, 0, list, ret, target);
        return ret;
    }

    public void combosumHelper(int[] nums, int currIdx, List<Integer> list, List<List<Integer>> ret, int target){

        // Base cases
        if (target < 0){
            return;
        }
        else if (target == 0){
            ret.add(new ArrayList<>(list));
            return;
        }
        else if (currIdx >= nums.length){
            return;
        }

        // Choose number
        list.add(nums[currIdx]);
        combosumHelper(nums, currIdx + 1, list, ret, target - nums[currIdx]);

        // If we do not choose adjust idx to reflect no dupes
        list.remove(list.size() - 1);
        currIdx += 1; 
        while (currIdx < nums.length && nums[currIdx] == nums[currIdx - 1]){
            currIdx += 1; 
        }
        combosumHelper(nums, currIdx, list, ret, target);
        return;
    }
}