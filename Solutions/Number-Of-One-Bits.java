// https://leetcode.com/problems/number-of-1-bits

class NumberOfOneBitsSolution {
    public int hammingWeight(int n) {

        // input is guaranteed to be a 32 bit integer
        int count = 0; 
        for (int i = 0; i < 32; i++){
            if ((n & 1) == 1){
                count += 1; 
            }
            n >>= 1; 
        }
        return count; 
    }
}