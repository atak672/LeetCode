// https://leetcode.com/problems/longest-substring-without-repeating-characters

class LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0; 
        int right = 0; 
        int n = s.length();
        int maxLength = 0; 

        // Characters can be any char
        // Here we will store the last noted index of the given char (or -1 if not seen)
        // This will help us check in O(1) if the current char is already in string or not
        int[] freq = new int[128];
        Arrays.fill(freq, -1);

        while (right < n){
            char currChar = s.charAt(right);
            // Either not seen or before the current start of string (i.e. not in our current window)
            if (freq[currChar] == - 1 || freq[currChar] < left){
                // Flag current char as being found at right index 
                freq[currChar] = right;
                maxLength = Math.max(maxLength, right - left + 1);
                right += 1; 
            }
            else {
                // We have a repeat. The next possible string w/o a repeat is setting start to after the last occurrence of the repeated char
                // that way the current char is no longer repeated and we can reset and repeat to see if we find a new maxLength
                left = freq[currChar] + 1; 
                freq[currChar] = right; 
                right += 1; 
            }


        }
        return maxLength;
    }
}