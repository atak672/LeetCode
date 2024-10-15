// https://leetcode.com/problems/find-the-duplicate-number

class FindTheDuplicateNumberSolution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); 

        for (int num : nums){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        for (int i : map.keySet()){
            if (map.get(i) > 1){
                return i;
            }
        }
        return -1; 
    }
}