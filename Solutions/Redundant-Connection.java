// https://leetcode.com/problems/redundant-connection

class RedundantConnectionSolution {
    public int[] findRedundantConnection(int[][] edges) {
        // This is not necessarily about finding a cycle
        // If given such a redundant graph, to make it good, we remove any edge within the cycle
        // But that does not necessarily satisfy the question, as we want to remove the edge in the cycle that occurs last in edges array
        

        // Create graph
        Map<Integer, List<Integer>> graph = new HashMap<>(); 
        for (int i = 1; i <= edges.length; i++){
            graph.put(i, new ArrayList<>());
        }
        int[] visited = new int[edges.length + 1];
        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            Arrays.fill(visited, 0);
            for (int i = 1; i <= edges.length; i++){
                if (visited[i] == 0){
                    if (dfs(i, graph, visited, -1)){
                        return new int[]{edge[0], edge[1]};
                    }
                }
            }
        }
        return new int[0];
    }   

    public boolean dfs(int currNode, Map<Integer, List<Integer>> graph, int[] visited, int parent){
        visited[currNode] = 1; 
        for (int neighbor : graph.get(currNode)){
            if (visited[neighbor] == 0){
                if (dfs(neighbor, graph, visited, currNode)){
                    return true;
                }
            }
            else if (visited[neighbor] == 1 && parent != neighbor){
                return true;
            }
        }
        return false;
    }
}