// https://leetcode.com/problems/walls-and-gates

class WallsAndGatesSolution {

    // For grid traversal
        int[] dirX = new int[]{-1, 0, 1, 0};
        int[] dirY = new int[]{0, -1, 0, 1};

    public void wallsAndGates(int[][] grid) {
        // Do a ripple effect
        // In a non-weighted graph, BFS gives shortest path
        // So we will find all 'treasures' and do BFS level by level
        // We go 1 level out of each gate, process them, continue
        // Each cell in the grid gets looked at once, which will be 
        // From its closest gate, so only updating once as well
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>(); 

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        bfs(grid, queue, m, n);
        return;
    }

    public void bfs(int[][] grid, Queue<int[]> queue, int m, int n){

        // Do not need visited array, can simpyl check if still max int
        // If not, already hit and updated by its closest gate

        // Keep track how far we are from gate node, do each level one at a time
        int dist = 0; 
        // Until no more nodes (every cell checked)
        while (! queue.isEmpty()){
            // Will be processing last additions, neighbors, so one additional depth level
            dist += 1; 
            int size = queue.size();
            // Loop make sures one level at a time
            // First loop == to number of gates, next level will be their neighbors, etc.
            for (int i = 0; i < size; i++){
                int[] currCell = queue.remove();
                for (int j = 0; j < 4; j++){
                    int newX = currCell[0] + dirX[j];
                    int newY = currCell[1] + dirY[j];
                    if (inBounds(newX, newY, m, n) && grid[newX][newY] == Integer.MAX_VALUE){
                        grid[newX][newY] = dist; 
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return;
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
