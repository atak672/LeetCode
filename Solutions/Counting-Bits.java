// https://leetcode.com/problems/counting-bits

class CountingBitsSolution {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];

        for (int i = 0; i <= n; i++){
            ret[i] = countOnes(i); 
        }
        return ret; 
        
    }
    private int countOnes(int n){
        int total = 0; 

        while (n != 0){
            total++;
            n &= (n-1);
        }
        return total; 

    }
}