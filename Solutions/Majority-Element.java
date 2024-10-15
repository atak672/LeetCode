// https://leetcode.com/problems/majority-element

class MajorityElementSolution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> counts = new HashMap<>(); 
        int length = nums.length; 

        for (int num : nums){
            counts.putIfAbsent(num, 0); 
            counts.put(num, counts.get(num) + 1);
        }

        for (int i : counts.keySet()){
            if (counts.get(i) > length/2){
                return i; 
            }
        }

        return -1; 
        
    }
}