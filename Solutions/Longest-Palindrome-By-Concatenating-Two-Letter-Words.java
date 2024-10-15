// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words

class LongestPalindromeByConcatenatingTwoLetterWordsSolution {
    public int longestPalindrome(String[] words) {

        int[][] counts = new int[26][26];
        int ret = 0; 

        for (String s : words){
            char firstLetter = s.charAt(0);
            char secondLetter = s.charAt(1);
            if (counts[firstLetter - 'a'][secondLetter - 'a'] >= 1){
                ret += 4; 
                counts[firstLetter - 'a'][secondLetter - 'a'] -= 1; 
            }
            else {
                counts[secondLetter - 'a'][firstLetter - 'a'] += 1; 
            }
        }
        
        for (int i = 0; i < 26; i++){
            if (counts[i][i] >= 1){
                ret += 2; 
                return ret;
            }
        }
        return ret;
    }
}