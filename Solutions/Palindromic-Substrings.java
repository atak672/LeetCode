// https://leetcode.com/problems/palindromic-substrings

class PalindromicSubstringsSolution {
    public int countSubstrings(String s) {


        // Can expand each out from the center as a 1 or 2 group

        // 1 letter at a time
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++){
            count += expandCenter(s, i, i);
        }

        // Expand doubles
        for (int i = 1; i < n; i++){
           count += expandCenter(s, i - 1, i);
        }
        return count;
    }


    public int expandCenter(String s, int left, int right){

        int n = s.length();
        int count = 0; 

        while (inBounds(n, left) && inBounds(n, right) && s.charAt(left) == s.charAt(right)){
            count += 1; 
            left -= 1; 
            right += 1; 
        }
        return count;
    }

    public boolean inBounds(int n, int x){
        if (x < 0 || x >= n){
            return false;
        }
        return true;
    }

}