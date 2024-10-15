// https://leetcode.com/problems/symmetric-tree

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
class SymmetricTreeSolution {
    public boolean isSymmetric(TreeNode root) {
        return isSameTreeMirrored(root.left, root.right);
    }
    private boolean isSameTreeMirrored(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        else if (left == null || right == null){
            return false;
        }
        else if (left.val != right.val){
            return false;
        }

        boolean compareOne = isSameTreeMirrored(left.left, right.right);
        boolean compareTwo = isSameTreeMirrored(left.right, right.left);
        return (compareOne && compareTwo);

    }
}