// https://leetcode.com/problems/clone-graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraphSolution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>(); 
        return cloneDFS(node, visited);
        
    }

    private Node cloneDFS(Node node, Map<Node, Node> map){
        if (node == null){
            return null;
        }

        if (map.keySet().contains(node)){
            return map.get(node);
        }

        map.put(node, new Node(node.val));
        for (Node neighbor : node.neighbors){
            map.get(node).neighbors.add(cloneDFS(neighbor, map));

        }
        return map.get(node); 
    }
}