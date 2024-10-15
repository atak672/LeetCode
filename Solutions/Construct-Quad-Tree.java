// https://leetcode.com/problems/construct-quad-tree

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class ConstructQuadTreeSolution {
    public Node construct(int[][] grid) {
        Node ret = constructHelper(grid, 0, 0, grid.length);
        return ret;
        
    }

    private Node constructHelper(int[][] grid, int row, int col, int size){
        
        if (size == 1 || sameValue(grid, row, col, size) != -1){
            return new Node(grid[row][col] == 1, true);
        }
        int new_size = size / 2; 
        Node newNode = new Node(true, false);
        newNode.topLeft = constructHelper(grid, row, col, new_size);
        newNode.topRight = constructHelper(grid, row, col + new_size, new_size);
        newNode.bottomLeft = constructHelper(grid, row + new_size, col, new_size);
        newNode.bottomRight = constructHelper(grid, row + new_size, col + new_size, new_size);
        return newNode;
    }

    private int sameValue(int[][] grid, int start, int end, int size){
        int val = grid[start][end];
        for (int i = start; i < start + size; i++){
            for (int j = end; j < end + size; j++){
                if (val != grid[i][j]){
                    return -1; 
                }
            }
        }
        return val;
    }
}