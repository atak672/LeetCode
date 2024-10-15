// https://leetcode.com/problems/basic-calculator-ii

import java.util.Stack;

class BasicCalculatorIISolution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");  // Remove all spaces
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char op = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }

            if (ch == '(') {
                stack.push(op == '+' ? 1 : -1);  // Push the sign before the '('
                stack.push(0);  // Push a zero to start a new sub-expression
                op = '+';
                currNum = 0;
            }

            if (!Character.isDigit(ch) || i == s.length() - 1 || ch == ')') {
                if (op == '+') {
                    stack.push(currNum);
                } else if (op == '-') {
                    stack.push(-currNum);
                } else if (op == '*') {
                    stack.push(stack.pop() * currNum);
                } else if (op == '/') {
                    stack.push(stack.pop() / currNum);
                }

                currNum = 0;
                op = ch;

                if (ch == ')') {
                    int temp = 0;
                    while (stack.peek() != 0) {
                        temp += stack.pop();
                    }
                    stack.pop();  // Remove the 0 marker
                    temp *= stack.pop();  // Apply the sign before the '('
                    stack.push(temp);
                }
            }
        }

        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;
    }
}

