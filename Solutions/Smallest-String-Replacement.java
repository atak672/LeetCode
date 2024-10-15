/*

Problem Statement:
Given a string word that may contain question marks (?) representing unknown characters and a string substr, 
your task is to find the lexicographically smallest string that can be formed by replacing all occurrences of ? in 
word with characters from substr. The replacement must ensure that substr can fully replace a contiguous substring
in word, and any ? characters can be replaced with any character.

Input:
- A string word (1 ≤ |word| ≤ 100), which may contain lowercase English letters and question marks (?).
- A string substr (1 ≤ |substr| ≤ 100), which contains only lowercase English letters.

Output:
Return the lexicographically smallest string formed by replacing the substr in word. If no valid replacement can be made, return -1.

 */


public class SmallestStringReplacementSolution {
    
    public static String getSmallestString(String word, String substr){
        List<Integer> starts = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        
        for (int i = 0; i <= word.length() - substr.length(); i++){
            for (int j = 0; j < substr.length(); j++){
                //System.out.print(word.charAt(i + j)+ "\n");
                if (word.charAt(i + j) != substr.charAt(j) && word.charAt(i + j) != '?'){
                    //System.out.print("hey\n");
                    break;
                }
                else {
                    //System.out.print("hey\n");
                    if (j == substr.length() - 1){
                        starts.add(i);
                    }
                }
            }
        }
    
        
        // Use start locations to find words and keep track of lexicography smaller ones
        String smallest = null;
        for (int start : starts){
            char[] temp = word.toCharArray();
            int currIdx = 0;
            for (int j = start; j < start + substr.length(); j++){
                temp[j] = substr.charAt(currIdx);
                currIdx += 1; 
            }
            fillInA(temp);
            String s = new String(temp);
            if (smallest == null || s.compareTo(smallest) < 0){
                smallest = s; 
            }
        }
        
        
        if (smallest == null){
            return "-1";
        }
        return smallest;
    }
    
    public static void fillInA(char[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == '?'){
                arr[i] = '?';
            }
        }
        return;
    }
    
    public static void main(String[] args) {
        String one = "vulnera?i??t???";
        String two = "abilities";
        System.out.print(getSmallestString(one, two));
    }
}
