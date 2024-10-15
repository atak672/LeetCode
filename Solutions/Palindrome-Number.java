// https://leetcode.com/problems/palindrome-number

class PalindromeNumberSolution {
    public boolean isPalindrome(int x) {
        // Cannot be negative
        if (x < 0){
            return false;
        }
        int copy = x; 
        int num = 0;
        while (x != 0){
            num *= 10; 
            int temp = x % 10; 
            num += temp; 
            x /= 10; 
        }
        if (num == copy){
            return true;
        }
        return false;

    }
}