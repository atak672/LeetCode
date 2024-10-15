// https://leetcode.com/problems/backspace-string-compare

class BackspaceStringCompareSolution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> wordOne = new Stack<>(); 
        Stack<Character> wordTwo = new Stack<>(); 

        for (char ch : s.toCharArray()){
            if (ch != '#'){
                wordOne.push(ch);
            }
            else if (! wordOne.isEmpty()){
                wordOne.pop();
            }
        }

         for (char ch : t.toCharArray()){
            if (ch != '#'){
                wordTwo.push(ch);
            }
            else if (! wordTwo.isEmpty()){
                wordTwo.pop();
            }
        }

        while (! wordOne.isEmpty() && ! wordTwo.isEmpty()){
            if (wordOne.pop() != wordTwo.pop()){
                return false; 
            }
        }

        if (wordOne.isEmpty() && wordTwo.isEmpty()){
            return true; 
        }
        return false; 

        
    }
}