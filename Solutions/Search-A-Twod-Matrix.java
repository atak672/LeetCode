// https://leetcode.com/problems/search-a-2d-matrix

class SearchATwodMatrixSolution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // When you do binary search, if the item is not in the array, it will return the spot in which it is supposed to be
        // i.e. end will be the number directly less, start will be greater
        // So do binary search on the starting column, the index of end will give you the desired row to then 
        // Do binary search in 

        // So we have an array arr[idx][0] that we are doing and manipualting to find idx correctly

        // Binary search on columns 
        int start = 0; 
        int end = matrix.length - 1; 

        while (start <= end){
            int mid = start + ((end - start)/2);
            if (matrix[mid][0] == target){
                return true;
            }
            else if (matrix[mid][0] > target){
                end = mid - 1; 
            }
            else {
                start = mid + 1; 
            }
        }
        // If not found, value at end will incldue value immediately smaller and the correct row
        // So now do binary search in arr[end][varies]
        if (end < 0){
            return false;
        }
        int row = end; 
        start = 0;
        end = matrix[0].length - 1; 

        while (start <= end){
            int mid = start + ((end - start)/2);
            if (matrix[row][mid] == target){
                return true;
            }
            else if (matrix[row][mid] > target){
                end = mid - 1; 
            }
            else {
                start = mid + 1; 
            }

         }
          return false;
    }
}