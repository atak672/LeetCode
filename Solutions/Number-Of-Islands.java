// https://leetcode.com/problems/number-of-islands

class NumberOfIslandsSolution {

    int[] dirX = new int[]{-1, 0, 1, 0};
    int[] dirY = new int[]{0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int numIslands = 0; 

        // BFS, if you need to use a wrapper, count it as an island
        // BFS is a queue FIFO
        int m = grid.length; 
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    numIslands += 1;
                    bfs(grid, i, j);
                }

            }
        }
        return numIslands;
    }

    private void bfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++){
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (inBounds(grid, newX, newY)){
                bfs(grid, newX, newY);
            }
        }
        return;
    }

    private boolean inBounds(char[][] grid, int x, int y){
        if (x < 0 || x >= grid.length){
            return false;
        }
        if (y < 0 || y >= grid[0].length){
            return false;
        }
        if (grid[x][y] != '1'){
            return false;
        }
        return true;
    }
}