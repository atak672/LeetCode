// https://leetcode.com/problems/evaluate-reverse-polish-notation

class EvaluateReversePolishNotationSolution {
    public int evalRPN(String[] tokens) {
        // When doing an op, it is always between the last 2 nums
        Stack<Integer> stack = new Stack<>(); 

        for (String str : tokens){
            if (str.equals("+")){
                int two = stack.pop();
                int one = stack.pop(); 
                stack.push(one + two);
            }
            else if (str.equals("-")){
                int two = stack.pop();
                int one = stack.pop(); 
                stack.push(one - two);
            }
            else if (str.equals("*")){
                int two = stack.pop();
                int one = stack.pop(); 
                stack.push(one * two);
            }
            else if (str.equals("/")){
                int two = stack.pop();
                int one = stack.pop(); 
                stack.push(one / two);
            }
            else {
                stack.push(Integer.valueOf(str));
            }

        }
        return stack.peek(); 
    }
}