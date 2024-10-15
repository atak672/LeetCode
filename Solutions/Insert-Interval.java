// https://leetcode.com/problems/insert-interval

class InsertIntervalSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // In a typical list of intervals, if we want to merge them, it is easiest to do so if we have it sorted by start time
        // The provided interval is given sorted on this condition. 
        // So, in order to start we essentially want to find where this new inserted interval would be
        // I am going to use a stack data structure to help process my intervals
            // This allows constant time access and the LIFO lets me merge intervals and compare them with this endpoint start point relationship

        Stack<int[]> stack = new Stack<>(); 

        int idx = 0; 
        int n = intervals.length;
        while (idx < n && intervals[idx][0] < newInterval[0]){
            stack.push(intervals[idx]);
            idx += 1; 
        }

        // We have reached the point where out interval would be considered sorted order if inserted (on the basis of start interval)
        // So what I will do here is see if the newInterval starts a new distinct interval or if it can be merged with its diret predecsor 
        if (stack.size() == 0 || newInterval[0] > stack.peek()[1]){
            stack.push(newInterval);
        }
        else {
            int[] elem = stack.pop();
            elem[1] = Math.max(elem[1], newInterval[1]);
            stack.push(elem);
        }

        // we are guaranteed to have at least 1 item in the stacl
        while (idx < n){
            if (intervals[idx][0] <= stack.peek()[1]){
                int[] elem = stack.pop();
                elem[1] = Math.max(elem[1], intervals[idx][1]);
                stack.push(elem);
            }
            else {
                stack.push(intervals[idx]);
            }
            idx += 1; 
        }

        // Stack LIFO -- it is storing our intervals in reverse order
        int[][] ret = new int[stack.size()][2];
        idx = stack.size() - 1; 
        while (! stack.isEmpty()){
            int[] interv = stack.pop();
            ret[idx][0] = interv[0];
            ret[idx][1] = interv[1];
            idx -= 1;
        }
        return ret;
    }
}