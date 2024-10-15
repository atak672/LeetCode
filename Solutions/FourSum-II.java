// https://leetcode.com/problems/4sum-ii

class FourSumIISolution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>(); 
        int ret = 0; 

        for (int num1: nums1){
            for (int num2: nums2){
                int val = -1 * (num1 + num2);
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }

        for (int num3: nums3){
            for (int num4 : nums4){
                int val = num3 + num4;
                ret += map.getOrDefault(val, 0);

            }
        }
        return ret; 
    }
}