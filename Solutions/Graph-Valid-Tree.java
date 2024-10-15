// https://leetcode.com/problems/graph-valid-tree

class GraphValidTreeSolution {
    public boolean validTree(int n, int[][] edges) {
        // e = v - 1 for any connected grapg
        // Count # of connected components. See if each is a valid tree (forest of trees)

        // Create the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0 ; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int connectedComponents = 0; 
        int[] visited = new int[n];
        for (int i = 0; i < n; i++){
            if (visited[i] == 0){
                connectedComponents += 1; 
                dfs(i, graph, visited);
            }   
        }

        return (connectedComponents == 1 && edges.length == n - 1);
    }

    public void dfs(int currNode, Map<Integer, List<Integer>> graph, int[] visited){
        visited[currNode] = 1; 
        for (int neighbor : graph.get(currNode)){
            if (visited[neighbor] == 0){
                dfs(neighbor, graph, visited);
            }
        }
        return;
    }
}