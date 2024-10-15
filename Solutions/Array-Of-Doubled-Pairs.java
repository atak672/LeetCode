// https://leetcode.com/problems/array-of-doubled-pairs

class ArrayOfDoubledPairsSolution {
    public boolean canReorderDoubled(int[] arr) {

        // Fact: Input array will have even length

        // As long as you can find an associated pair for each item either * 2 or / 2 then true!
        // Problem is for a given number, you cant just pair everything -- a number may be the double or the one that gets doubled 
        // Imagine [1, 2, 4, 8] --> i give 2 to 4, then left with [1, 8] even though [1, 2] and [4, 8] is valid 
        // [4, 1, 2, 8] --> use 4 -- we want to find either 2 or 8. Hit 1, we want a 2. Find 2 --> pair it with 4
        // What if I sort and then do 2 sum but with a product spin. 

    
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int a : arr){
            if (a <= 0){
                maxHeap.offer(a);
            }
            else if (a > 0){
                minHeap.offer(a);
            }
        }

        if (! reorderHelper(minHeap)){
            return false;
        }
        else if (! reorderHelper(maxHeap)){
            return false;
        }
        return true;
    }

    public boolean reorderHelper(PriorityQueue<Integer> pq){
         Map<Integer, Integer> map = new HashMap<>(); 
         
         while (! pq.isEmpty()){
            // Each num, check if it exists in hashmap, if so pair it by subtracting the count thus far
            // else, add 2 * num to O(1) check if double exists, increment value count by 1 
            // so if [1, 1, 2, 2] -- we will add 1 : 1 in map. Then 1 : 2. then 2 will subtract, then 2 will subtract -- > 0 all values so true, false otherwise
            int num = pq.poll(); 

            if (map.keySet().contains(num) && map.get(num) > 0){
                map.put(num, map.get(num) - 1);
            }
            else {
                map.putIfAbsent(num * 2, 0);
                map.put(num * 2, map.get(num * 2) + 1);
            }
            
        }
        
        for (int key : map.keySet()){
            if (map.get(key) != 0){
                return false;
            }
        }
        return true;
    }
}