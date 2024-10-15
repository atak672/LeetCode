// https://leetcode.com/problems/word-break

class WordBreakSolution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 0; j < n; j++){
            for (int i = 0; i <= j; i++){
                if (set.contains(s.substring(i, j + 1)) && dp[i]){
                    dp[j + 1] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}