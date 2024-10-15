// https://leetcode.com/problems/diameter-of-binary-tree

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
class DiameterOfBinaryTreeSolution {
    int diameter = 0; 

    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
        // Similar idea to just calculating the height of an aribtrary tree
        // The height of a tree at a given node is 1 + max(leftHeight, rightHeight)
        // We can recursivley calculate the height of the tree, however for a given node
        // We can use the height calculations to see the diameter at a given node
        // compare it to a currentMax, and then return the overall at the end
    }
    private int findHeight(TreeNode root){
        if (root == null){
            return 0; 
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
