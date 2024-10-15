// https://leetcode.com/problems/surrounded-regions

class SurroundedRegionsSolution {

    int[] dirX = new int[]{-1, 0, 1, 0};
    int[] dirY = new int[]{0, -1, 0, 1};

    public void solve(char[][] board) {

        int m = board.length; 
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && ! visited[i][j] && board[i][j] == 'O'){
                    dfs(board, i, j, m, n, visited);
                }
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (! visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        return;    
    }


    public void dfs(char[][] grid, int x, int y, int m, int n, boolean[][] visited){
        visited[x][y] = true; 

        for (int i = 0; i < 4; i++){
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (inBounds(newX, newY, m, n) && ! visited[newX][newY] && grid[newX][newY] == 'O'){
                dfs(grid, newX, newY, m, n, visited);
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