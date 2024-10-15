// https://leetcode.com/problems/string-matching-in-an-array

class StringMatchingInAnArraySolution {
    public List<String> stringMatching(String[] words) {

        List<String> ret = new ArrayList<>(); 

        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words.length; j++){
                if (words[j].contains(words[i]) && words[i] != words[j]){
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret; 
    }
}