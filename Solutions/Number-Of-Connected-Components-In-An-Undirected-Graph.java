// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph

class NumberOfConnectedComponentsInAnUndirectedGraphSolution {
    public int countComponents(int n, int[][] edges) {

        // Connected components. Use wrapper BFS/DFS function and count number of wraps

        // Initialize hashmap for easy graph traversal
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        // Visited array-- 0 if no, 1 if yes 
        int[] visited = new int[n];
        int numComponents = 0; 

        for (int i = 0; i < n; i++){
            if (visited[i] == 0){
                numComponents += 1;  
                visited[i] = 1; 
                bfs(i, map, visited);
            }
        }
        return numComponents; 
    }

    public void bfs(int node, Map<Integer, List<Integer>> map, int[] visited){
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(node);
        while (! queue.isEmpty()){
            int currNode = queue.remove(); 
            for (int neighbor : map.get(currNode)){
                if (visited[neighbor] == 0){
                    queue.add(neighbor); 
                    visited[neighbor] = 1; 
                }
            }
        }
        return;
    }
}
