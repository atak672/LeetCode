// https://leetcode.com/problems/max-area-of-island

class MaxAreaOfIslandSolution {

    int[] dirX = new int[]{-1, 0, 1, 0};
    int[] dirY = new int[]{0, -1, 0, 1};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0; 

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    int tempArea = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, tempArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y){
        grid[x][y] = 0;
        int area = 1; 
        for (int i = 0; i < 4; i++){
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (inBounds(grid, newX, newY) && grid[newX][newY] == 1){
                area += dfs(grid, newX, newY); 
            }
        }
        return area;
    }


    public boolean inBounds(int[][] grid, int x, int y){
        if (x < 0 || x >= grid.length){
            return false;
        }
        if (y < 0 || y >= grid[0].length){
            return false;
        }
        return true;
    }
}
