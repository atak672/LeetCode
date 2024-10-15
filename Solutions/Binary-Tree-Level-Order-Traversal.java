// https://leetcode.com/problems/binary-tree-level-order-traversal

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
class BinaryTreeLevelOrderTraversalSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>(); 
        levelOrderHelper(root, 0, ret);
        return ret;
        
    }

    public void levelOrderHelper(TreeNode root, int level, List<List<Integer>> ret){
        if (root == null){
            return;
        }

        if (ret.size() == level){
            ret.add(new ArrayList<>());
        }

        ret.get(level).add(root.val);
        levelOrderHelper(root.left, level + 1, ret);
        levelOrderHelper(root.right, level + 1, ret);
        return;
    }
}