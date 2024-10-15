// https://leetcode.com/problems/subsets-ii

class SubsetsIISolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Pattern: sort to get rid of duplicates 
        // We can check duplicates by seeing if the number prior to current elem is the same
        // We skip ONLY if this holds and we did not use the number at that decision in the backtracking recursion tree

        // Sort input array to assist later on for dupe detection
        Arrays.sort(nums);
        

        // Initialize all other data structures
        List<Integer> currSet = new ArrayList<>(); 
        List<List<Integer>> ret = new ArrayList<>();

        // Recursive call
        subsetHelper(nums, 0, currSet, ret);

        // Populated answer
        return ret;
    }

    public void subsetHelper(int[] num, int currIdx, List<Integer> currSet, List<List<Integer>> ret){

        if (currIdx >= num.length){
            ret.add(new ArrayList<>(currSet));
            return;
        }

        // Now, we can either select number or not -- will add additional logic for duplicates in a second

        // We need to add duplicates logic
        // Essentially, if we skip a number we want to find the next idx where the value at idx is not equal to the num skiped


        // Pick the number
        currSet.add(num[currIdx]);
        // Set up new state and pass it into recursive function
        subsetHelper(num, currIdx + 1, currSet, ret);

        // After this returns, exhausted all branches stemmming from choosing #
        currSet.remove(currSet.size() - 1); // Remove number to reset state, now it reflects "not choosing"
        // Adding skip logic here. When skipping a number, recurse starting at element no equal to skip 

        currIdx += 1; 
        while (currIdx < num.length &&  num[currIdx] == num[currIdx - 1]){
            currIdx += 1;
        }
        subsetHelper(num, currIdx, currSet, ret);

        return;
    }
}