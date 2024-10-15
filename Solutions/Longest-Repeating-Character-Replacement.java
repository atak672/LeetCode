// https://leetcode.com/problems/longest-repeating-character-replacement

class LongestRepeatingCharacterReplacementSolution {
    public int characterReplacement(String s, int k) {

        // Again, we want to find the longest (contiguous) segment of a given word that satisifes some criteria
        // Here, we want to find the longest string s.t. it has only repeating characters
        // But there is a catch, we can 'change' k chars that are not the majority into the majority
        // But we only need to return the # here

        // Initialize the window and grab string size. Intialize maxLength var
        int left = 0; 
        int right = 0; 
        int n = s.length(); 
        int maxLength = 0; 

        // Consists of only uppercase letetrs
        int[] freq = new int[26];
        int majority = 0; 
        
        // while loop to build and slide window
        while (right < n){

            // We have the size of the string given by right - left + 1
            // We essentially need to check if a given string is a valid input
            // Take the Length of string - occurrences of majority character and see if its <= k
            // If so it is valid, and see if we can find a larger char
            char ch = s.charAt(right);
            // Add item to right to show frequency added to string
            freq[ch - 'A'] += 1;
            majority = Math.max(freq[ch - 'A'], majority);


           
            
            if ((right - left + 1) - majority <= k){

                maxLength = Math.max(maxLength, right - left + 1);
                right += 1; 

            }

            // Invalid. Sliding window means we do need to increase right at each iteration, so right increases
            // But the next valid possible string is simply moving left over by 1, and right over by one
            // We have already found a string of some [left, right] (say size 5, so we check size 6)
            // If this current string of length 6 is invalid, then left ++ right++ -- still looking for size 6
            // As this is the only value that could change our answer
            else {
                // removing item from left, so dont need to include in count
                freq[s.charAt(left) - 'A'] -= 1; 
                left += 1; 
                right += 1; 
            }
        }
        return maxLength;
    }

}