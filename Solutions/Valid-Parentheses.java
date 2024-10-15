// https://leetcode.com/problems/valid-parentheses

class ValidParenthesesSolution {
    public boolean isValid(String s) {
        // Stack LIFO, the last immediate opening must match the first closing found

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else {
                if (stack.isEmpty() || (ch == '}' && stack.peek() != '{')){
                    return false;
                }
                else if (stack.isEmpty() || (ch == ']' && stack.peek() != '[')){
                    return false;
                }
                else if (stack.isEmpty() || (ch == ')' && stack.peek() != '(')){
                    return false;
                }
                stack.pop(); 
            }
        }
        return stack.isEmpty();
    }
}