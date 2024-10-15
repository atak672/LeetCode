// https://leetcode.com/problems/longest-common-prefix

class LongestCommonPrefixSolution {
    public String longestCommonPrefix(String[] strs) {

    

        Arrays.sort(strs); 

        String prefix = new String(); 
        String wordOne = strs[0];
        String wordTwo = strs[strs.length - 1];

        int i = 0; 
        while (i < wordOne.length() && i < wordTwo.length()){
            if (wordOne.charAt(i) != wordTwo.charAt(i)){
                return prefix; 
            }
            else{
                prefix = wordOne.substring(0, i + 1);
            }
            i += 1; 
        }
        return prefix; 
    }
}