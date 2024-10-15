// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class LetterCombinationsOfAPhoneNumberSolution {
    public List<String> letterCombinations(String digits) {

        // Make a map to use mappings of letter to list of valid nunbers (decisons)
        // Can backtrack, at each option select a decision (either 1 2 or 3) -- recurse to next
        // Once next == size of digits string, add and 
        
        Map<String, List<String>> decisions = new HashMap<>();
        char ch = 'a';
        int val = 3;
        for (int i = 2; i <=9 ; i++){
            String num = String.valueOf(i);
            if (i == 7 || i == 9){
                val = 4; 
            }
            decisions.putIfAbsent(num, new ArrayList<>());
            for (int j = 0; j < val; j++){
                decisions.get(num).add(String.valueOf(ch));
                ch += 1; 
            }
            val = 3; 
        }



        List<String> ret = new ArrayList<>();
         if (digits.length() == 0){
            return ret;
        }

        StringBuilder combo = new StringBuilder();
        backtrackCombos(digits, 0, combo, ret, decisions);
        return ret;
        
    }


    public void backtrackCombos(String digits, int currIdx, StringBuilder combo, List<String> ret, Map<String, List<String>> decisions){

        if (currIdx >= digits.length()){
            ret.add(combo.toString());
            return;
        }

        String num = String.valueOf(digits.charAt(currIdx));
        for (int i = 0; i < decisions.get(num).size(); i++){
            combo.append(decisions.get(num).get(i));
            backtrackCombos(digits, currIdx + 1, combo, ret, decisions);
            combo.deleteCharAt(combo.length() - 1);
        }
        return;
    }
}