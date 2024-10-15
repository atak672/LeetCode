// https://leetcode.com/problems/basic-calculator

class BasicCalculatorSolution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char op = '+';
        int result = 0;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }
            
            if (ch == '(') {
                int j = i, count = 0;
                for (; i < len; i++) {
                    if (s.charAt(i) == '(') count++;
                    if (s.charAt(i) == ')') count--;
                    if (count == 0) break;
                }
                currNum = calculate(s.substring(j + 1, i));
            }
            
            if (!Character.isDigit(ch) && ch != ' ' || i == len - 1) {
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
        }
        
        for (int num : stack) {
            result += num;
        }
        
        return result;
    }
}

