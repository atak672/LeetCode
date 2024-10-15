// https://leetcode.com/problems/palindrome-partitioning

class PalindromePartitioningSolution {
    public List<List<String>> partition(String s) {

        List<String> list = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();

        backtrack(s, 0, list, ret);
        return ret;

        
    }

    public void backtrack(String s, int currIdx, List<String> list, List<List<String>> ret){

        if (currIdx >= s.length()){
            ret.add(new ArrayList<>(list));
            return;
        }


        // Now we need backtracking options
        StringBuilder temp = new StringBuilder();


        for (int i = currIdx; i < s.length(); i++){
            if (isPalindrome(s, currIdx, i)){
                list.add(s.substring(currIdx, i + 1));
                backtrack(s, i + 1, list, ret);
                list.remove(list.size() - 1);
            }

        }
        return;
    }

    public boolean isPalindrome(String s, int start, int end){
        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start += 1; 
            end -= 1; 
        }
        return true;
    }
}