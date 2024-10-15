// https://leetcode.com/problems/subsets

class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>(); 
        List<Integer> currList = new ArrayList<>();
        subsetHelper(nums, 0, ret, currList);
        return ret;
    }

    public void subsetHelper(int[] nums, int currIdx, List<List<Integer>> ret, List<Integer> currList){


        // We reached a leaf, each level after the root represents an idx for a number we are making a 
        // Binary decision on (include or exclude)
        // Once we get to level n, we have processed all and reached root, which represents our solutions

        if (currIdx == nums.length){
            ret.add(new ArrayList<>(currList));
            return;
        }

        // Choice 1: Include the number at level n (idx n)
        // Can think of this as a preorder traversal
        // Add num, traverse left tree, traverse right tree
        currList.add(nums[currIdx]);
        subsetHelper(nums, currIdx + 1, ret, currList);

        // When this returns we essentially processed all of a nodes left subtree
        // Now for other decision: DO NOT INCLUDE
        currList.remove(currList.size() - 1);
        subsetHelper(nums, currIdx + 1, ret, currList);

        // When this returns, we covered left and right subtrees for current state, return to backtrack
        return;
    }
}