// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

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
class ConvertSortedArrayToBinarySearchTreeSolution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode ret = createTree(nums, 0, nums.length - 1);
        return ret;
    }

    private TreeNode createTree(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int mid = start + ((end - start)/2);
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = createTree(nums, start, mid - 1);
        newNode.right = createTree(nums, mid + 1, end);
        return newNode;
    }
}