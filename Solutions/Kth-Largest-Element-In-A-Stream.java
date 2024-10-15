// https://leetcode.com/problems/kth-largest-element-in-a-stream

class KthLargest {

    // Keep priorityqueue in natural order sorting
    // Maintain it for size k
    // Head of pq will be kth largest
    // My implementation: if less than k, will return the smallest #
    // If pq is of size k, need to add next num, then remove head 
    //i.e if # is bigger than our kth largest, it will essentially shift all numbers less back, 
    // This allows us to obtain the new kth elem by removing the now k+1 elem
    // if less than kth elem, will simply add to head and be removed
    

    private PriorityQueue<Integer> pq; 
    private int size;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.size = k;         
        for (int num : nums){
            this.add(num);
        }
    }

    public int add(int val) {
        // Add element
        this.pq.offer(val);
        if (this.size < this.pq.size()){
            pq.poll();
        }
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */