// https://leetcode.com/problems/validate-binary-search-tree

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
class ValidateBinarySearchTreeSolution {
    public boolean isValidBST(TreeNode root) {
        // Do a level order traversal and see if the nodes are sorted!

        List<Integer> sortedNums = new ArrayList<>(); 
        postOrder(root, sortedNums);

        for (int i = 1; i < sortedNums.size(); i++){
            if (sortedNums.get(i) <= sortedNums.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    public void postOrder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }

        postOrder(root.left, list);
         list.add(root.val);
        postOrder(root.right, list);
    }
}