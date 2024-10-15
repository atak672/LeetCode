// https://leetcode.com/problems/word-search

class WordSearchSolution {

    // Runtime: # of occurrences of first letter (at worst m*n) and the DFS calls which is depth word -- O(M*N*K) where k is length of word
    // Space: O(M*N + K) -- M*N for size of visited arr, and possible starts with the letter, k for recursion stack size during dfs 
    

    int[] dirX = new int[]{-1, 0, 1, 0};
    int[] dirY = new int[]{0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {

        // We will be starting froom each cell that starts with the first letter of word -- find them
        // bactracking DFS that checks horizontal/vertical neighbors 1). Make sure inBounds and 2). Not already in constructed word
        // if we find word, return true -- pass it back up
        // Loop for all cells that start with letter - if nothing, return false


        int m = board.length;
        int n = board[0].length;
        boolean[][] currLetters = new boolean[m][n];
        char ch = word.charAt(0);

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == ch){
                    boolean val = dfs(board, i, j, 1, word, currLetters, m, n);
                    if (val) return true;
                }
            }
        }

        return false;      
    }

    // Now that we found each possible start, we will do a backtracking method
    // We will start at the letter looking for item at idx 1, if it is found without violating checks, recurse again, increasing index by 1
    // If we get to idx >= word.length, we found a valid word, return true somehow
    public boolean dfs(char[][] nums, int currX, int currY, int nextIdx, String word, boolean[][] currLetters, int m, int n){

        if (nextIdx >= word.length()){
            return true;
        }
        currLetters[currX][currY] = true;
        for (int i = 0; i < 4; i++){
            int newX = currX + dirX[i];
            int newY = currY + dirY[i];
            // If valid bounds that are not currently in our growing word 
            if(inBounds(newX, newY, m, n) && ! currLetters[newX][newY] && nums[newX][newY] == word.charAt(nextIdx)){
                if (dfs(nums, newX, newY, nextIdx + 1, word, currLetters, m, n)){
                    return true;
                }
                // remove from word since we backtracked
            }
        }
        currLetters[currX][currY] = false;
        return false;
    }

    public boolean inBounds(int x, int y, int m, int n){
        if (x < 0 || x >= m){
            return false;
        }
        else if (y < 0 || y >= n){
            return false;
        }
        return true;
    }
}