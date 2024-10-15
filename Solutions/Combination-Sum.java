// https://leetcode.com/problems/combination-sum

class CombinationSumSolution {

    // Notes: Negative numbers could screw up this implementation
    // 0 can never be allowed as it results in infinite combinations
    // If a 0 did exist however in a list, and say we had a restriction where it could be used only once
    // Can use an array that does not contain zero (i.e. ignore it), find all combos that sum regardless
    // Add all of these to a list, and then for eaqch sublist, add an additional copy that contains 0
    // 
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        comboHelper(nums, 0, list, ret, target);
        return ret;
    }

    public void comboHelper(int[] nums, int currIdx, List<Integer> list, List<List<Integer>> ret, int target){

        // If index is out of bounds
        if (currIdx >= nums.length){
            return;
        }
        // Current state is over target.. PRUNE can never decrease with positive and non-zero #'s'
        else if (target < 0){
            return;
        }
        // Found a state in which it satisfies conditions, include inr et
        else if (target == 0){
            ret.add(new ArrayList<>(list));
            return;
        }

        // Can either use number, add to list and adjust target
        // Then I can select again so use the same idx
        list.add(nums[currIdx]);
        comboHelper(nums, currIdx, list, ret, target - nums[currIdx]);

        // Once this returns, all paths using it are exhausted
        // Now lets do not using it
        list.remove(list.size() - 1);
        comboHelper(nums, currIdx + 1, list, ret, target);

        // Once this returns, right tree exhausted
        // can return to backtrack and reset to previous state
        return;
    }
}