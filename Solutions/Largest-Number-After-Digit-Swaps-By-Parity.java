// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity

class LargestNumberAfterDigitSwapsByParitySolution {
    public int largestInteger(int num) {

        // You want to swap the largest possible number to the earliest position
        // i.e. 135 --> 531 rather than 315
        // Biggest number in earliest position gives largest value when swapped 


        // Find largest odd number + idx (-1 if none)
        // Find largest even number + idx (-1 if none)

        // Start from left most number, find largest num of associated parity
        // If none (-1), go to next value 

        // However... we can do multple swaps
        // Need an efficient way to repeat the process above and consume nums
        // Priority Queue?? But how do we make sure we arent using the same number for itself -- ig it dosnt matter.. nothing larger = good

        int copy = num; 
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        PriorityQueue<Integer> even = new PriorityQueue<>();

        while (copy > 0){
            int val = copy % 10;
            if (val % 2 == 0){
                even.offer(val);
            }
            else {
                odd.offer(val);
            }
            copy /= 10;
        }


        int ret = 0; 
        int placement = 1; 
        copy = num;
        while (copy > 0){
            int val = copy % 10;
            if (val % 2 == 0){
                ret += placement * even.poll();
            }
            else {
                ret += placement * odd.poll();
            }
            placement *= 10;
            copy /= 10;
        }
        return ret;
    }
}