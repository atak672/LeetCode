// https://leetcode.com/problems/daily-temperatures

class DailyTemperaturesSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        // Going to use a stack
        // If empty, no comparisons (everything paired or just starting) -- add to stack
        // else while stack is not empty and .peek < currval, pop, find diff in index, add diff at that index 
        // after loop, is anythinf is left, pop and add 0 for those indices

        Stack<Integer> stack = new Stack<>(); 
        int[] ret = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            while (! stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                ret[index] = i - index;
            }
            stack.push(i);
        }
        return ret; 
    }
}