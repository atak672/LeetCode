// https://leetcode.com/problems/course-schedule-ii

class CourseScheduleIISolution {

    // Same deal: topological ordering of vertices. If cycle exists, no solution
    // Just need the ordering of the vertices this time

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Intiailize the graph
        // Courses are [0, numCourses - 1]
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites){
            // Order is (a, b) where b is a prereq to a so b -> a is the edge
            map.get(prereq[1]).add(prereq[0]);
        }

        // Now we need to do DFS
        // Need to keep track of visited for efficiency and recursionStack for cycle detection
        int[] visited = new int[numCourses];
        int[] recursionStack = new int[numCourses];
        // We now also need the ordering though. To actually topological sort vertices, 
        // You need to sort them in descending order of their post operation time
        // this means that as they are finished processing and no longer needed from the stack,
        // We mark them with a time or unit of time measurement. Vertices that are more central
        // (i.e. have more descendents will have a higher time, as they are the source of a growing
        // Path and stay in the stack longer)
        // Can use a stack itself to keep track. Top will be the last vertex to finish processing
        Stack<Integer> topoOrder = new Stack<>();
        // Wrapper function
        for (int i = 0; i < numCourses; i++){
            if (visited[i] == 0){
                boolean cycle = dfs(i, map, visited, recursionStack, topoOrder);
                if (cycle){return new int[]{};}
            }
        }

        // If we find no cycle, the stack contains our ordering!
        int[] ret = new int[numCourses];

        int idx = 0; 
        while (! topoOrder.isEmpty()){
            ret[idx] = topoOrder.pop();
            idx += 1; 
        }
        return ret;
    }

    public boolean dfs(int currNode, Map<Integer, List<Integer>> map, int[] visited, int[] recursionStack, Stack<Integer> topoOrder){
        // Mark as visited and that its current frame of stack
        visited[currNode] = 1; 
        recursionStack[currNode] = 1; 

        for (int neighbor : map.get(currNode)){
            if (recursionStack[neighbor] == 1){
                return true;
            }
            else if (visited[neighbor] == 0){
                boolean cycle = dfs(neighbor, map, visited, recursionStack, topoOrder);
                if (cycle){return true;}
            }
        }

        // Done processing, set recursionStack back, and add it to our ordering
        recursionStack[currNode] = 0; 
        topoOrder.push(currNode);

        // No cycle found yet
        return false;
    }
}