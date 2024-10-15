// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram

class MinimumNumberOfStepsToMakeTwoStringsAnagramSolution {
    public int minSteps(String s, String t) {

        // Given that s and t are the same size

       int[] counts = new int[26];
        int ret = 0; 

        // Add counts for characters in s
        for (char ch : s.toCharArray()){
            counts[ch - 'a'] += 1; 
        }
        
        // Take away counts for characters in t
        for (char ch : t.toCharArray()){
            counts[ch - 'a'] -= 1; 
        }

        for (int num : counts){
            if (num < 0){
                ret -=  num;
            }
        }
        return ret;
    }
}