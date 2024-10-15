// https://leetcode.com/problems/copy-list-with-random-pointer

class CopyListWithRandomPointerSolution {
    public Node copyRandomList(Node head) {

        // I am going to do a first pass that deep copies nodes and set maps
        // I am going to use a hashmap that basically maps old to copied/new node
        // I will then retraverse and set the .random/.next on this relationship
        // O(N) runtime with O(N) extra space from hashmap
        if (head == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<>(); 

        Node temp = head; 
        while (temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head; 
        while (temp != null){
            Node curr = map.get(temp);
            curr.next = map.get(temp.next); 
            curr.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head); 
    }
}
