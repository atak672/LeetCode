// https://leetcode.com/problems/contains-duplicate

class ContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numPresent = new HashSet<>(); 

        for (int num : nums){
            if (! numPresent.add(num)){
                return true; 
            } 
        }
        return false; 
    }
}