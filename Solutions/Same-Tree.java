// https://leetcode.com/problems/same-tree

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
class SameTreeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Traverse trees at same time, if same val, continue, else false
        // If a false occurs somewhere, pass it back up recursion stack

        // Some base cases to avoid .val on a null root
        if (p == null && q == null){
            return true;
        }
        else if (p == null){
            return false;
        }
        else if (q == null){
            return false;
        }
        // Different values? return false
        if (p.val != q.val){
            return false;
        }

        boolean treesLeft = isSameTree(p.left, q.left);
        boolean treesRight = isSameTree(p.right, q.right);
        if (treesLeft && treesRight){
            return true;
        }
        return false;
    }
}
