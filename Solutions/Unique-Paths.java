// https://leetcode.com/problems/unique-paths

class UniquePathsSolution {
    public int uniquePaths(int m, int n) {
        // Can only go down or right for a given grid
        // Can work backwards from the goal [m-1][n-1] and count the # of ways to do previous areas
        // Base case is when m || n == 1. This is first row or col and u can only get their from successive rights or downs
        // Form a given [m][n]... To have gotten there from a down u do [m-1][n] and [m][n-1] for a right
        // each i,j has at least 1 path to it
        int[][] mem = new int[m][n];
        return uniquePathsHelper(m, n, mem);

        }

        public int uniquePathsHelper(int m, int n, int[][] mem){

            if (m == 1 || n == 1){
                return 1; 
            }

            if (mem[m - 1][n - 1] != 0){
                return mem[m - 1][n - 1];
            }

            mem[m - 1][n - 1] = uniquePathsHelper(m - 1, n , mem) + uniquePathsHelper(m, n - 1, mem);
            return mem[m - 1][n - 1];
        }
        
    }
