// https://leetcode.com/problems/subtree-of-another-tree

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
class SubtreeOfAnotherTreeSolution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // Traverse on root, is we find subroot.val = root.val, check isSameTree(ish)
        // if true yes, if no keep searching. If you get to end without anything... return false

        if (root == null){
            return false;
        }

        if (root.val == subRoot.val){
            if (isSameTree(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }

    private boolean isSameTree(TreeNode root, TreeNode sub){
        if (sub == null && root == null){
            return true;
        }
        if (root == null || sub == null){
            return false;
        }
        if (root.val != sub.val){
            return false;
        }
        return isSameTree(root.left, sub.left) && isSameTree(root.right, sub.right);
    }
}