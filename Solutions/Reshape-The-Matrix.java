// https://leetcode.com/problems/reshape-the-matrix

class ReshapeTheMatrixSolution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        
        int m = mat.length; 
        int n = mat[0].length;

        if (r * c != m * n){
            return mat;
        }


        int[][] ret = new int[r][c];

        int row = 0; 
        int col = 0; 

        // Stick row, increment col, once col >= c; increment by 1, reset col

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ret[row][col] = mat[i][j];
                
                col += 1; 
                if(col >= c){
                    row += 1; 
                    col = 0;
                }

            }
        }
        return ret;   
    }
}