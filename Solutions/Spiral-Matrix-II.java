// https://leetcode.com/problems/spiral-matrix-ii

class SpiralMatrixIISolution {
    public int[][] generateMatrix(int n) {


        // Spiral order is basically when we reach somethign visited or out of bounds we stop 
        // m*n iterations to visit everything 


        // Visit array
        boolean[][] visited = new boolean[n][n]; 

        // Return array
        int[][] ret = new int[n][n];

        // Helps with directioning. We go across all columns (j which we deem y), etc.
        int[] dirX = new int[]{0, 1, 0, -1};
        int[] dirY = new int[]{1, 0, -1, 0};
        int x = 0; 
        int y = 0; 
        int direction = 0; 

        for (int i = 1; i <= n * n; i++){
            // Mark as visited -- guaranteed valid in each iteration
            visited[x][y] = true;
            // Marking the item in order from [1, n*n]
            ret[x][y] = i;


            // Making next (x, y) assuming valid 
            int newX = x + dirX[direction];
            int newY = y + dirY[direction];

            // If item is out of bounds or already visited, switch directions
            if (! inBounds(newX, newY, n) || visited[newX][newY]) {
                // Keeps direction on [0, 3] index and cycles it once it hits 4
                direction = (direction + 1) % 4; 
                // Recalculate x and y after switching directions
                x = x + dirX[direction];
                y = y + dirY[direction];
            }
            else {
                // Else we just use newX and newY
                x = newX;
                y = newY;
            }
        }
        return ret;
    }

    // checks if we are out of bounds in the array/matrix
    public boolean inBounds(int x, int y, int n){
        if (x < 0 || x >= n){
            return false;
        }
        else if (y < 0 || y >= n){
            return false;
        }
        return true;
    }
}