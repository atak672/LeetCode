// https://leetcode.com/problems/diagonal-traverse

class DiagonalTraverseSolution {
    public int[] findDiagonalOrder(int[][] mat) {

        Map<Integer, List<Integer>> map = new HashMap<>(); 
        int m = mat.length;
        int n = mat[0].length;

        // Row is an offset for which diagonal it is in
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int diagonal = i + j;
                map.putIfAbsent(diagonal, new ArrayList<>());
                map.get(diagonal).add(mat[i][j]);
            }
        }

        int[] ret = new int[m * n];
        int idx = 0; 

        for (int key : map.keySet()){
            if (key % 2 == 0){
                Collections.reverse(map.get(key));
            }
            for (int num : map.get(key)){
                ret[idx] = num;
                idx += 1; 
            }
        }
        

       return ret;
    }
}