// https://leetcode.com/problems/top-k-frequent-elements

class TopKFrequentElementsSolution {
    public int[] topKFrequent(int[] nums, int k) {

        // Max freq is n
        int n = nums.length;
        List<List<Integer>> freq = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            freq.add(new ArrayList<>());
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums){
            counts.putIfAbsent(num, 0);
            counts.put(num, counts.get(num) + 1);
        }

       

        for (int key : counts.keySet()){
            freq.get(counts.get(key)).add(key);
        }

       int[] ret = new int[k];
       int idx = 0; 
        for (int i = n; i >= 0; i--){
            for (int val : freq.get(i)){
                ret[idx] = val;
                idx += 1; 
                if (idx >= k){
                    return ret;
                }
            }
        }
        return ret;
    }
}