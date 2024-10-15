// https://leetcode.com/problems/number-of-provinces

class NumberOfProvincesSolution {
    HashMap<Integer, Boolean> visited = new HashMap<>(); 

    public int findCircleNum(int[][] isConnected) {
        int count = 0; 
        fillDictionary(isConnected.length);
        for (int i = 0; i < isConnected.length; i++){
            if (visited.get(i) == false){
                count += 1; 
                DFS(i, isConnected);
            }
        }
        return count; 
    }

    private void fillDictionary(int x){
        for (int i = 0; i < x; i++){
            visited.put(i, false);
        }
    }

    private void DFS(int node, int[][] isConnected){
        visited.put(node, true);
        for (int i = 0; i < isConnected.length; i++){
            if (isConnected[node][i] == 1 && visited.get(i) != true){
                DFS(i, isConnected);
            }
        }
        return; 
    }
}