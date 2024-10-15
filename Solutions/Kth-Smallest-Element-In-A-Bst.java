// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
class KthSmallestElementInABstSolution {
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>(); 
        inOrder(root, list);
        
        if (list.size() < k){
            return -1; 
        }

        return list.get(k - 1);

        
    }

    public void inOrder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
        return;
    }
}