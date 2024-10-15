// https://leetcode.com/problems/longest-palindrome

class LongestPalindromeSolution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> counts = new HashMap<>(); 

        for (char ch : s.toCharArray()){
            counts.putIfAbsent(ch, 0);
            counts.put(ch, counts.get(ch) + 1);
        }

        int maxLength = 0; 
        boolean odd = false; 
        for (int num : counts.values()){
            if (num % 2 == 0){
                maxLength += num; 
            }
            else{
                maxLength += num - 1; 
                odd = true;   
            }
            
        }

        if (odd){
            return maxLength + 1; 
        }
        return maxLength; 

         
        
    }
}