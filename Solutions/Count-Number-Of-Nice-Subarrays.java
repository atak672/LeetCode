// https://leetcode.com/problems/count-number-of-nice-subarrays

class CountNumberOfNiceSubarraysSolution {
    public int numberOfSubarrays(int[] nums, int k) {

        // Build prefix sum array that counts # of odd numebrs up to but not including index i

        int[] prefix = new int[nums.length + 1];

        // Remember prefix[i] is everything up to nut not including nums[i]
        int val = 0; 
        for (int i = 1; i < prefix.length; i++){
            if (nums[i - 1] % 2 == 1){
                val = 1; 
            }
            else {
                val = 0; 
            }
            prefix[i] = prefix[i - 1] + val; 
        }

        // for (int pre : prefix){
        //     System.out.println(pre);
        // }

        Map<Integer, Integer> map = new HashMap<>(); 
        int ret = 0; 

        for (int pre : prefix){
            if (map.keySet().contains(pre)){
                ret += map.get(pre); 
            }
            map.putIfAbsent(k + pre, 0);
            map.put(k + pre, map.get(k + pre) + 1);
        }
        return ret; 
    }
}