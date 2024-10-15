// https://leetcode.com/problems/degree-of-an-array

class DegreeOfAnArraySolution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> indices = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            if (! indices.keySet().contains(nums[i])){
                indices.put(nums[i], new ArrayList<>());
                indices.get(nums[i]).add(i);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (int i = nums.length - 1; i >= 0; i-= 1){
            if (indices.get(nums[i]).size() == 1){
                indices.get(nums[i]).add(i);
            }

        }

        int freq = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            freq = Math.max(freq, map.get(key));
        }

        int shortestLength = nums.length;
        for (int key : map.keySet()) {
            if (map.get(key) == freq){
                int val = indices.get(key).get(1) - indices.get(key).get(0) + 1;
                shortestLength = Math.min(shortestLength, val);
            }
           
        }
        return shortestLength;
    }
}