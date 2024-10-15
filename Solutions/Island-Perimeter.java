// https://leetcode.com/problems/island-perimeter

class IslandPerimeterSolution {

    int[] dirRows = new int[]{-1, 0, 1, 0};
    int[] dirCols = new int[]{0, -1, 0, 1};

    public int islandPerimeter(int[][] grid) {

        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        int p = 0; 

        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                if (! visited[i][j] && grid[i][j] == 1){
                    visited[i][j] = true; 
                    p = dfs(i, j, grid, visited, numRows, numCols);
                }
            }
        }
        return p; 
    }


    private int dfs(int x, int y, int[][] grid, boolean[][] visited, int numRows, int numCols){
        int count = 0;

        for (int i = 0; i < 4; i++){
            int newX = x + dirRows[i];
            int newY = y + dirCols[i];

            if (! inBounds(newX, newY, numRows, numCols) || grid[newX][newY] == 0){
                
                count += 1; 
               
            }

            if (inBounds(newX, newY, numRows, numCols) && ! visited[newX][newY] && grid[newX][newY] == 1){
                visited[newX][newY] = true;
                count += dfs(newX, newY, grid, visited, numRows, numCols);
            }
        }
        return count; 
    }

    private boolean inBounds(int x, int y, int rows, int cols){
        if (x < 0 || x >= rows){
            return false;
        }
        else if (y < 0 || y >= cols){
            return false;
        }
        return true;
    }
}