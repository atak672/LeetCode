// https://leetcode.com/problems/check-if-array-is-good

class CheckIfArrayIsGoodSolution {
    public boolean isGood(int[] nums) {


        // Essentially, we need to ensure that the array has all numbers [1, n] as well as 2 occurrences of n
        // Can do it in O(N) -- use a hashset and put in all numbers 1 to n
        // Iterate through the array, make sure it is in the set, if it is not, means the # is out of bounds or already occurred, return false
        // If it is in the set, just remove it to mark we used it
        // Only case is the number n, we need it to occur twice, so, just count to make sure each time we encounter


        Set<Integer> set = new HashSet<>();
        int n = nums.length - 1; 

        for (int i = 1; i < n; i++){
            set.add(i);
        }

        int countN = 0; 
        for (int num : nums){
            if (num == n){
                countN += 1; 
            }
            else if (! set.contains(num)){
                return false;
            }
            else {
                set.remove(num);
            }
        }
        return set.size() == 0 && countN == 2;        
    }
}