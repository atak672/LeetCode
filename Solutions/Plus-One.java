// https://leetcode.com/problems/plus-one

class PlusOneSolution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i] += 1; 
                return digits; 
            }
            digits[i] = 0; 
        }

        int[] ret = new int[digits.length + 1];
        ret[0] = 1; 
        return ret; 

    }
}