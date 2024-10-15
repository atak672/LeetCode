// https://leetcode.com/problems/pacific-atlantic-water-flow

class PacificAtlanticWaterFlowSolution {

    int[] dirX = new int[]{-1, 0, 1, 0};
    int[] dirY = new int[]{0, -1, 0, 1};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        
        // Do two DFS: 1. Is using the nodes on pacific side as source until all directly boarding are visited
        // 2. Same thing but from the atlantic side. 
        // Do a DFS but only continue if some number is larger than the current value. This means water could flow from neighbor
        // To the source and essentially out to the ocean 
        // Cells that are visited by both DFS's have a clear path from both oceans, and if filled could overflow and satisfy the
        // Problem statement

        // TLDR: Two DFSs wiht 2 diff boolean[][] visited arrays. One from cells boarding atlantic side, the other pacific 
        // The DFS will only consider neighbors that have not been visited, or are greater than it. 
        // Basically anything on this path, if filled, can overflow to thr associated ocean. If met by both DFS's , can 
        // Flow to both oceans

        int m = heights.length; 
        int n = heights[0].length; 
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];

        // PACIFIC SIDE. i = 0, 0<=j<=n-1
        for (int j = 0; j < n; j++){
            if (! pacific[0][j]){
                dfs(heights, 0, j, m, n, pacific);
            }
        }
        // Pacific: 0 <= i <= m - 1 for j = 0
        for (int i = 0; i < m; i++){
            if (! pacific[i][0]){
                dfs(heights, i, 0, m, n, pacific);
            }
        }

        // Atlantic side: 0 <= i <= m - 1; for j = n - 1
        for (int i = 0; i < m; i++){
            if (! atlantic[i][n-1]){
                dfs(heights, i, n-1, m, n, atlantic);
            }
        }
        // i == m - 1 for 0 <= j <= n - 1
        for (int j = 0; j < n; j++){
            if (! atlantic[m-1][j]){
                dfs(heights, m-1, j, m, n, atlantic);
            }
        }

        List<List<Integer>> ret = new ArrayList<>(); 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (atlantic[i][j] && pacific[i][j]){
                    ret.add(Arrays.asList(i, j));
                }
            }
        }
        return ret;
    }

    public void dfs(int[][] grid, int x, int y, int m, int n, boolean[][] visited){
        visited[x][y] = true; 
        for (int i = 0; i < 4; i++){
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (inBounds(newX, newY, m, n) && ! visited[newX][newY] && grid[newX][newY] >= grid[x][y]){
                dfs(grid, newX, newY, m, n, visited);
            }
        }
        return;
    }

    public boolean inBounds(int x, int y, int m, int n){
        if (x < 0 || x >= m){
            return false;
        }
        if (y < 0 || y >= n){
            return false;
        }
        return true;
    }
}