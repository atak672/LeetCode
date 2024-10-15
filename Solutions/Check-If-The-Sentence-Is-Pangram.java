// https://leetcode.com/problems/check-if-the-sentence-is-pangram

class CheckIfTheSentenceIsPangramSolution {
    public boolean checkIfPangram(String sentence) {

        // let's do 3 variations: 
            // 1. sentence only consists of lowercase letters
            // 2. Sentence contains any character
            // 3. Return string of missing characters (if any) or ""
 
        HashSet<Character> check = new HashSet<>(); 
       
       for (int i = 0; i < sentence.length(); i++){
           check.add(sentence.charAt(i));
       }

       if (check.size() == 26){
           return true; 
       }
       return false; 
    }
}