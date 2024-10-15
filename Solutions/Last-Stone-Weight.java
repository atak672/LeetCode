// https://leetcode.com/problems/last-stone-weight

class LastStoneWeightSolution {
    public int lastStoneWeight(int[] stones) {

        // Need to keep access to the heaviest stones
        //priority queue!!!!
        // We want heaviest tho so need reverse natural order to determine priority (i.e. 4 > 3 )

        // Create pq and populate it with stones
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        for (int stone : stones){
            pq.offer(stone);
        }
        
        while (pq.size() > 1){
            int x = pq.poll(); 
            int y = pq.poll(); 
            if (x != y){
                int newStone = Math.max(x, y) - Math.min(x, y);
                pq.offer(newStone);
            }
        }
        if (pq.size() > 0){
            return pq.peek();
        }
        return 0;
    }
}
