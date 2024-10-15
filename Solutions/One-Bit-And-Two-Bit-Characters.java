// https://leetcode.com/problems/1-bit-and-2-bit-characters

class OneBitAndTwoBitCharactersSolution {
    public boolean isOneBitCharacter(int[] bits) {
        // when u see a 1, it must be paired with a 0 or 1 next to it

        int i = 0;
        while (i < bits.length){
            if (i == bits.length - 1){
                return true;
            }
            if (bits[i] == 0){
                i += 1; 
            }
            if (bits[i] == 1){
               i += 2; 
            }
        }
        return false;
    }
}