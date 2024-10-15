// https://leetcode.com/problems/number-of-operations-to-make-network-connected

class NumberOfOperationsToMakeNetworkConnectedSolution {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n -1){
            return -1; 
        }

        // You essentially just need to connect all disconnected compoenntns 
        // Only way to do this is to remove an edge that is with a cycle and create edge (u->v) where u is in one
        // Compomnent and v in the other


        // Form a graph with a hashmap using int n nodes and edges define in connections (undirected)
        // Idea, do DFS to essentially count the number of "islands" within graph. Within each respective 
        // DFS, identify if that group has a cycle, flag it, and count if islands == cycles then return # islands
        // Else, return -1

        // First step, make graph nicer for access
        Map<Integer, List<Integer>> graph = new HashMap<>(); 
        constructGraph(n, connections, graph);

        // Next, do an iterative DFS with a wrapper function, just implement DFS for now, will add specifics after
        boolean[] visited = new boolean[n];
        int numIslands = 0; 
        int numCycles = 0; 

        // Thought process, to connect one component to another component, we need 1 edge
        // And for there to exist an extra edge, we need a cycle. 

        // If we need to connect n vertices, we need n-1 edges in the MINIMAL case
        // This defines a tree in which all vertices are connected (no cycles)
        // So if connections does not contain at least n - 1 edges, it is a chop... return -1
        // Else, it is technically possible, so just return islands - 1

        for (int i = 0; i < n; i++){
            if (! visited[i]){
                numIslands += 1; 
                visited[i] = true;
                dfs(i, graph, visited);
            }
        }
        

        return numIslands - 1; 
        
    }

    private void dfs(int currNode, Map<Integer, List<Integer>> graph, boolean[] visited){
        
        for (int neighbor : graph.get(currNode)){
            if (! visited[neighbor]){
                visited[neighbor] = true;
                dfs(neighbor, graph, visited);
                
            }
        }

        return;
    }

    private void constructGraph(int nodes, int[][] connections, Map<Integer, List<Integer>> graph){
        for (int i = 0; i < nodes; i++){
            graph.put(i, new ArrayList<Integer>());
        }

        for (int[] connection : connections){
            int nodeOne = connection[0];
            int nodeTwo = connection[1];
            graph.get(nodeOne).add(nodeTwo);
            graph.get(nodeTwo).add(nodeOne); 
        }
    }
}