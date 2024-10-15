// https://leetcode.com/problems/count-good-nodes-in-binary-tree

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
class CountGoodNodesInBinaryTreeSolution {
    public int goodNodes(TreeNode root) {
        // Idea: Traverse with helper function in which second param tells maximum value on path to node
        int ret = traverseHelper(root, root.val);
        return ret;
    }

    private int traverseHelper(TreeNode root, int maxVal){
        if (root == null){
            return 0;
        }
        if (maxVal <= root.val){
            return 1 +  traverseHelper(root.left, Math.max(maxVal, root.val)) +  traverseHelper(root.right, Math.max(maxVal, root.val));
        }
       return traverseHelper(root.left, Math.max(maxVal, root.val)) +  traverseHelper(root.right, Math.max(maxVal, root.val));
    }
}