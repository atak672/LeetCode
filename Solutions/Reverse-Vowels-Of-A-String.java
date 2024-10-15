// https://leetcode.com/problems/reverse-vowels-of-a-string

class ReverseVowelsOfAStringSolution {
    public String reverseVowels(String s) {
        
        String vowelString = "AEIOUaeiou";
        char[] letters = s.toCharArray(); 
        int start = 0; 
        int end = s.length() - 1;


        HashSet<Character> vowels = new HashSet<>(); 
        for (int i = 0; i <= 9; i++){
            vowels.add(vowelString.charAt(i));
        }
 

        while (start < end){
           // Iterate until start is on a vowel
           while (start < end && ! vowels.contains(letters[start])){
               start += 1; 
            }
        
        // Iterate until end is on a vowel
             while (start < end && ! vowels.contains(letters[end])){
               end -= 1; 
            }

            char temp = letters[start];
            letters[start] = letters[end]; 
            letters[end] = temp; 


            start += 1; 
            end -= 1;
            }

        return String.valueOf(letters);

        
    }
}