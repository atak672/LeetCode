// https://leetcode.com/problems/range-addition

class RangeAdditionSolution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ret = new int[length];

        for (int[] update : updates){
           ret[update[0]] += update[2];
           if (update[1] + 1 < ret.length){
                ret[update[1] + 1] -= update[2];
           }
        }


        for (int i = 0; i < ret.length; i++){
            if (i != 0){
                ret[i] += ret[i - 1];
            }
        }
        return ret;
    }
}