// https://leetcode.com/problems/valid-anagram

class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        
        // Use array to represent letters and their respective counts
        int[] letters = new int[26];

        // Use first string to populate letters map
        for (char c : s.toCharArray()){
            int i = (int) (c - 97);
            letters[i] += 1; 
        }

        // Subtract letters in second string. If true anagram, all should be 0
        for (char ch : t.toCharArray()){
            int i = (int) (ch - 97);
            letters[i] -= 1; 
        }


        for (int i : letters){
            if (i != 0){
                return false; 
            }
        }
        return true; 
        
    }
}