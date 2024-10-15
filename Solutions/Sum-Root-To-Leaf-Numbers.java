// https://leetcode.com/problems/sum-root-to-leaf-numbers

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
class SumRootToLeafNumbersSolution {
    int count = 0; 

    public int sumNumbers(TreeNode root) {
        helper(root, 0); 
        return count; 
    }

    private void helper(TreeNode root, int a){
        if (root == null){
            count += a; 
            System.out.print(a); 
            return; 
        }
        a = (a * 10) + root.val; 

        if (root.left == null && root.right == null){
            helper(root.left, a); 
        }

        else if (root.right != null && root.left != null){
            helper(root.left, a);
            helper(root.right, a);
        }

        else if (root.left != null){
            helper(root.left, a); 
        }
        else {
            helper(root.right, a);
        }
        return; 
    }
}