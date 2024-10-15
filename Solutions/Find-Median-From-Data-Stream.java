// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> right;
    PriorityQueue<Integer> left;

    public MedianFinder() {
        this.right = new PriorityQueue<>();
        this.left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {


        if (left.size() + right.size() == 0){
            right.offer(num);
        }

        else if (num >= right.peek()){
            right.offer(num);
            if (right.size() > left.size() + 1){
                left.offer(right.poll());
            }
        }
        else {
            left.offer(num);
            if (left.size() > right.size() + 1){
                right.offer(left.poll());
            }
        }
        return;
    }
    
    public double findMedian() {

        int leftSize = this.left.size();
        int rightSize = this.right.size();

        if (leftSize + rightSize == 0){
            return 0;
        }
        else if (leftSize > rightSize){
            return this.left.peek();
        }
        else if (rightSize > leftSize){
            return this.right.peek();
        }
        else {
            return ((this.left.peek() / 1.0) + (this.right.peek() / 1.0))/2;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */