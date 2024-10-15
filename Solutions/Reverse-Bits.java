// https://leetcode.com/problems/reverse-bits

public class ReverseBitsSolution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0; 

        for (int i = 0; i < 32; i++){
            int bit = n & 1; 
            int temp = bit << (31 - i);
            ret = ret | temp; 
            n >>>= 1; 
        }
        return ret; 
        
    }
}