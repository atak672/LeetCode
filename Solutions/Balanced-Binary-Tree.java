// https://leetcode.com/problems/balanced-binary-tree

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
class BalancedBinaryTreeSolution {

    public boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1){
            return false;
        }
        return true;
    }

    private int getHeight(TreeNode root){
        if (root == null){
            return 0; 
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1 || leftHeight == -1){
            return -1; 
        }

        if (Math.abs(leftHeight - rightHeight) > 1){
           return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
