// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeZigzagLevelOrderTraversalSolution {
    int count = 0;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>(); 
        helper(root, 1, ret);
        return ret; 
    }

    private void helper(TreeNode root, int x, List<List<Integer>> lst){
    if (root == null){
        return; 
    }

   if (x > lst.size()) {
        lst.add(new ArrayList<>());
    }

    if (x % 2 == 1){
        lst.get(x-1).add(root.val);
    }
    else{
        lst.get(x-1).add(0, root.val);
    }
    x += 1; 
    helper(root.left, x, lst);
    helper(root.right, x, lst);

    }
}