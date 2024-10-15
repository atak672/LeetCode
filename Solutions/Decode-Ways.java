// https://leetcode.com/problems/decode-ways

class DecodeWaysSolution {
    public int numDecodings(String s) {

        int n = s.length();

        // Assumes I have a string of at least length 1 
        if (n == 0){
            return 0;
        }

        int[] dp = new int[n + 1];  // Length of string is idx that indexes to tell # of ways to decode up to including nth char

        // Ofc length of 0 is 0 ways to decode
        dp[0] = 1; 
        // For 1, need to just see if value at idx = is not 0, otherwise its a valid digit

        if (s.charAt(0) != '0'){
            dp[1] = 1;
        }
        else {
            dp[1] = 0;
        }

        for (int i = 2; i <= s.length(); i++){
    
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }

           
            if ((s.charAt(i - 2) == '1' && s.charAt(i - 1) <= '9') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')){
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}