// https://leetcode.com/problems/rotate-image

class RotateImageSolution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Transpose matrix
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
        
        for (int i = 0; i < n; i++){
            int left = 0; 
            int right = n - 1; 
            while (left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left += 1; 
                right -= 1; 
            }
        }


        return;
    }
}