// https://leetcode.com/problems/basic-calculator-iii

import java.util.Stack;

class BasicCalculatorIIISolution {
    public int calculate(String s) {
        return evaluate(s.toCharArray(), new int[]{0});
    }
    
    private int evaluate(char[] chars, int[] index) {
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char op = '+';
        
        for (; index[0] < chars.length; index[0]++) {
            char ch = chars[index[0]];

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }
            
            if (ch == '(') {
                index[0]++;
                currNum = evaluate(chars, index);
            }
            
            if (!Character.isDigit(ch) && ch != ' ' || index[0] == chars.length - 1) {
                if (op == '+') {
                    stack.push(currNum);
                } else if (op == '-') {
                    stack.push(-currNum);
                } else if (op == '*') {
                    stack.push(stack.pop() * currNum);
                } else if (op == '/') {
                    stack.push(stack.pop() / currNum);
                }
                op = ch;
                currNum = 0;
            }
            
            if (ch == ')') {
                break;
            }
        }
        
        int result = 0;
        for (int num : stack) {
            result += num;
        }
        
        return result;
    }
}
