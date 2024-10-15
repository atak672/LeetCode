// https://leetcode.com/problems/spiral-matrix

class SpiralMatrixSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dirN = new int[]{0, 1, 0, -1};
        int[] dirM = new int[]{1, 0, -1, 0};

        List<Integer> ret = new ArrayList<>(); 
        int n = matrix.length; 
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];

       // Every time where the next step is out of bounds or visited we switch 90 degrees CW

       int x = 0; 
       int y = 0; 
       int dir = 0; 

       while (ret.size() != n *m) {
            visited[x][y] = true;
            ret.add(matrix[x][y]);
            int newX = x +  dirN[dir];
            int newY = y + dirM[dir];
            if (! inBounds(newX, newY, n, m) || visited[newX][newY]){
                dir = (dir + 1) % 4; 
                x += dirN[dir];
                y += dirM[dir];
            }
            else {
                x = newX;
                y = newY;
            }
       }
        return ret;
    }

    public boolean inBounds(int x, int y, int n, int m){
        if (x < 0 || x >= n){
            return false;
        }
        else if (y < 0 || y >= m){
            return false;
        }
        return true;
    }
}