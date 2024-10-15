// https://leetcode.com/problems/find-the-derangement-of-an-array

class FindTheDerangementOfAnArraySolution {
    public int findDerangement(int n) {

        if (n <= 1){
            return 0; 
        }
        long[] DP = new long[n + 1];

        DP[1] = 0; 
        DP[2] = 1; 
        for (int i = 3; i < DP.length ; i++){
            DP[i] = (i - 1) * (DP[i - 1] + DP[i - 2]) % 1_000_000_007;
        }   

        return (int) (DP[DP.length - 1]);
        
    }
}