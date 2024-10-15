// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorOfABinarySearchTreeSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Find the node in which the BST property no longer holds

        TreeNode ret = root; 

        while(ret != null){
            if (ret.val > p.val && ret.val > q.val){
                ret = ret.left;
            }
            else if (ret.val < p.val && ret.val < q.val){
                ret = ret.right;
            }
            else return ret;
        }

        return ret;
        
    }
}