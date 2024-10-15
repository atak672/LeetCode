// https://leetcode.com/problems/course-schedule

class CourseScheduleSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // We want to find if an ordering of classes is valid given [x, y] where y is a prereq to x
        // We must take all prereqs before a class that requires that
        // So can think think of it as an ordered list of classes s.t. for some class v, it never occurs before its necessary predecessors
        // Topological sort: an ordering of vertices s.t. if v comes before u, v is a predecsor to u, verties never come before predecesors on any path
        // For this question, if a topological ordering of vertices exists, then the schedule is good. Topo ordering only exists for DAGS, so if a cycle
        // Exists in the graph constructed by prereq array, then impossible


        // This question isnt directly asking about the ordering itself
        // So we just need to detect a cycle in a directed graph -- can use DFS and see if we find a backedge in the recursion stack


        // First, initialize the graph as a map
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        // Courses are [0, numCourses - 1]
        for (int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites){
            // Of the form [a, b] where b is a prereq to a ... so we want edge a -> b to dictate predecesor ordering and resultant topo ordering
            map.get(prereq[1]).add(prereq[0]);
        }

        // Now that map is initialized, we are going to do the DFS 
        // The goal of this is to find a backedge. Or while traversing, do we find a backedge to a node currently in the recursion stack -- a cycle

        // Wrapper function in case of multiple connected components
        int[] recursionStack = new int[numCourses];
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            if (visited[i] == 0){
                boolean cycleDetected = dfs(i, map, visited, recursionStack);
                if (cycleDetected){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int currNode, Map<Integer, List<Integer>> map, int[] visited, int[] recursionStack){
        // Add to visited and add to recursion stack, so if any calls are made, we know it is a predecsor to the node on the current path
        visited[currNode] = 1; 
        recursionStack[currNode] = 1; 
        for (int neighbor : map.get(currNode)){
            // For each neighbor, check if it is currently in the recursion stack 

            if (recursionStack[neighbor] == 1){
                return true; 
            }
            else if (visited[neighbor] == 0){
                boolean cycle = dfs(neighbor, map, visited, recursionStack);
                if (cycle){
                    return true; 
                }
            }
        }
        // When you are done processing this node, release it from recursionStack
        recursionStack[currNode] = 0; 
        return false; 
    }
}