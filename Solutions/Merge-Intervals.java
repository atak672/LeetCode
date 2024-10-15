// https://leetcode.com/problems/merge-intervals

class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>(); 
        for (int[] interval : intervals){
            if (stack.size() > 0 && interval[0] <= stack.peek()[1]){
                stack.peek()[1] = Math.max(stack.peek()[1], interval[1]);
            }
            else {
                stack.push(interval);
            }
        }
        

        int[][] ret = new int[stack.size()][2];
        int idx = stack.size() - 1; 
        while (! stack.isEmpty()){
            ret[idx] = stack.pop();
            idx -= 1; 
        }
        return ret;
    }
}