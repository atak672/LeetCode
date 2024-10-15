// https://leetcode.com/problems/invert-binary-tree

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
class InvertBinaryTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
        
    }

    private void invertTreeHelper(TreeNode root){
        if (root == null){
            return;
        }
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return;
    }
}