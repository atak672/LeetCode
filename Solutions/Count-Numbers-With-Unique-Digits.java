// https://leetcode.com/problems/count-numbers-with-unique-digits

class CountNumbersWithUniqueDigitsSolution {
    public int countNumbersWithUniqueDigits(int n) {

        int count = 10; 
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return count;
        }


        int firstNum = 9; // Cannot be 0
        int availableNums = 9; 
        int currIdx = 0;
        for (int i = 2; i <= n; i++){
            firstNum *= (availableNums - currIdx);
            count += firstNum;
            currIdx += 1; 
        }
        return count;
        
    }
}