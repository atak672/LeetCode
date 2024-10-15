// https://leetcode.com/problems/rotting-oranges

class RottingOrangesSolution {
    // Ripple effect BFS: shortest path between rotten and non rotten
    // Can do BFS -- level wise. Do each level with the first being
    // Each rotten fruit. Then check their neighbors, processing
    // Each level out from the rotten fruit together
    // We want the minimum # of seconds, so it is shortest path from rotten
    // to non-rotten as long as they are ADJACENT
    // At end, iterate to see if any 1's remain, if so return -1, else seconds recorded
    // There is a relationship between depth of BFS and time required to rot
    // Each level iteration is 1 second. At each depth, if a neighbor is found that is
    // Not rottened, this means we need an extra time interval to rot it (equa to curr depth)
    // If we reach an iteration with no neighbors found, we have rottened everything possible
    // And the time to do so is equal to depth/curr level - 1, as at the final level/depth
    // We found nothing new to rot, so that depth is not necessary 


    // Needed for grid traversal
    int[] dirX = new int[]{-1, 0, 1, 0};
    int[] dirY = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {

        // Will return to edge cases

        // Sizes to avoid redundant calls
        int m = grid.length; 
        int n = grid[0].length; 
        
        // Queue for BFs in-level traversal
        Queue<int[]> queue = new LinkedList<>();

        
        // Find all rotten oranges in order to do ripple BFS (in-level)
        // BFS finds shortest path in non-weighted graph
        // minimum time to rot fruit is equal to shortest path to fresh fruit
        // Via adjacent neighbors
        int freshFruit = 0; 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                else if (grid[i][j] == 1){
                    freshFruit += 1; 
                }
            }
        }

        // Base case: Current solution assumes some rotten fruit and some fresh fruit
        // 1: No fresh fruit (0) -- I believe mine will be correct if there is rotten
        // 2: No rotten fruit & no fresh (0) -- will return -1 (wrong)
        // 3: no rotten, at least 1 fresh (-1) -- will return -1 (captured correctly in final check)

       if (freshFruit == 0){
        return 0;
       }

        // Time until no more fruit to rot
        int time = bfs(grid, queue, m , n);
       // System.out.print(time);

        // Check if any fresh fruit remains
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }


    // BFS function that finds time by using its relationship to depth of traversal
    // Do not need to keep track of visited as we can just 'rot' fruit by changing 1 to 2
    public int bfs(int[][] grid, Queue<int[]> queue, int m, int n){
        
        // Depth of current neighbors if found
        int depth = 0; 
        while (! queue.isEmpty()){
            int size = queue.size(); 
            depth += 1; 
            for (int i = 0; i < size; i++){
                int[] currCell = queue.remove(); 
                for (int j = 0; j < 4; j++){
                    int newX = currCell[0] + dirX[j];
                    int newY = currCell[1] + dirY[j];
                    if (inBounds(newX, newY, m, n) && grid[newX][newY] == 1){
                        // If adjacent fresh fruit, rot it, add to queue for traversal
                        grid[newX][newY] = 2; 
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return depth - 1; 
    }


    // Function to make sure I stay within grid bounds
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
