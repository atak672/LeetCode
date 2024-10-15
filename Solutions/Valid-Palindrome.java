// https://leetcode.com/problems/valid-palindrome

class ValidPalindromeSolution {
    public boolean isPalindrome(String s) {
        // Two pointer method
        // two cases: 1. odd (pointers will equal each other at middle)
        // 2. Even (end < start)

        // converts to lowercase (case insensitive via problem statement)
        // Alpha numeric characters are 'a' - 'z' and '0' - '9'
        s = s.toLowerCase(); 

        int start = 0; 
        int end = s.length() - 1; 

        while (start < end){
            while (start < end && ! isAlphanumeric(s.charAt(start))){
                start += 1; 
            }
            while (start < end && ! isAlphanumeric(s.charAt(end))){
                end -= 1; 
            }
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start += 1; 
            end -= 1; 
        }
        return true;
    }

    private boolean isAlphanumeric(char ch){
        if (ch >= 'a' && ch <= 'z'){
            return true; 
        }
        else if (ch >= '0' && ch <= '9'){
            return true; 
        }
        else {
            return false;
        }
    }
}