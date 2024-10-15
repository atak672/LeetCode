// https://leetcode.com/problems/flood-fill

class FloodFillSolution {

    int[] dirX = new int[]{-1, 0, 1, 0};
    int[] dirY = new int[]{0, -1, 0, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if (image[sr][sc] == color){
            return image;
        }

        bfs(image, sr, sc, image[sr][sc], color, image.length, image[0].length);
        return image;

    }

    private void bfs(int[][] grid, int sr, int sc, int prevColor, int newColor, int m, int n){
        grid[sr][sc] = newColor;
        for (int i = 0; i < 4; i++){
            int newX = sr + dirX[i];
            int newY = sc + dirY[i];
            if (inBounds(grid, newX, newY, m, n) && grid[newX][newY] == prevColor){
                bfs(grid, newX, newY, prevColor, newColor, m, n);
            }
        }
        return;
    }

    private boolean inBounds(int[][] grid, int x, int y, int m, int n){
        if (x >= m || x < 0){
            return false;
        }
        else if (y >= n || y < 0){
            return false;
        }
        return true;
    }
}
