// https://leetcode.com/problems/longest-palindromic-substring

class LongestPalindromicSubstringSolution {
    public String longestPalindrome(String s) {

        int n = s.length();
        int left = 0; 
        int right = 0; 
        int[] coords = new int[2];

        // Expand from single center
        for (int i = 0; i < n; i++){
            expandCenter(s, i, i, coords);
            if (coords[1] - coords[0] > right - left){
                left = coords[0];
                right = coords[1];
            }
                
        }

        for (int i = 1; i < n; i++){
            expandCenter(s, i - 1, i, coords);
            if (coords[1] - coords[0] > right - left){
                left = coords[0];
                right = coords[1];
            }
        }

        return s.substring(left, right + 1);
    }

    public void expandCenter(String s, int left, int right, int[] coords){
        int n = s.length();
        while (inBounds(n, left) && inBounds(n, right) && s.charAt(left) == s.charAt(right)){
            coords[0] = left;
            coords[1] = right;
            left -= 1; 
            right += 1; 
        }
        return;
    }




    public boolean inBounds(int n, int x){
        if (x < 0 || x >= n){
            return false;
        }
        return true;
    }
}