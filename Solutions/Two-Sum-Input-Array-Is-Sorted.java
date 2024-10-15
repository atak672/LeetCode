// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class TwoSumInputArrayIsSortedSolution {
    public int[] twoSum(int[] numbers, int target) {

        // Goal of question: two-sum but improved
        // We want two different numbers (elements in array) to sum to target
        // Array is sorted in increasing order (clues me to use two pointer)
        // I.e. have start and end pointers point to first and last elem
        // if number if greater than target, we decrease end pointer
        // Bc array is sorted, increases start will only increase sum
        // Decreases end, decreases
        // Can use incremental method as if its too large every number after start and before
        // End will be too big

        // Can use same number twice (i.e. start != end)
        // Needs O(1) space
        // Exactly one solution
        int start = 0; 
        int end = numbers.length - 1; 

        while (start < end) {
            if (numbers[start] + numbers[end] > target){
                end -= 1; 
            }
            else if (numbers[start] + numbers[end] < target){
                start += 1; 
            }
            else {
                return new int[]{start + 1, end + 1};
            }
        }
        return new int[]{-1, -1};
        
    }
}