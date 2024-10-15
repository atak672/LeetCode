// https://leetcode.com/problems/permutations

class PermutationsSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>(); 
        List<Integer> currPermutation = new ArrayList<>();
        Set<Integer> visited = new HashSet<>(); 
        permuteHelper(nums, currPermutation, visited, ret);
        return ret;
        
    }

    public void permuteHelper(int[] nums, List<Integer> currPermutation, Set<Integer> visited, List<List<Integer>> ret){
        // We found an answer (leaf node) -- add to return array
        if (currPermutation.size() == nums.length){
            ret.add(new ArrayList<>(currPermutation));
            // valid answer, no need to go further, backtrack
            return;
        }

        // For each state, lets loop through all valid decisions starting from this and leading to successive state
        for (int i = 0; i < nums.length; i++){
            // If valid decision (i.e. not already in permutation)
            int val = nums[i];
            if (! visited.contains(val)){
                visited.add(val);
                currPermutation.add(val);
                // We found next state, plug into recursive function to recurse from here
                permuteHelper(nums, currPermutation, visited, ret);
                // After we do this pre-proccessing, (pre-order visit/we processed it/included into order), we need to remove it so we can 'backtrack'
                // No other valid paths from this value
                visited.remove(val);
                // Should be most recent thing added to our list for this current stack frame
                currPermutation.remove(currPermutation.size() - 1);
            }
        }
        return;
    }
}