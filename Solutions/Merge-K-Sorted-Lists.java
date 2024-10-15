// https://leetcode.com/problems/merge-k-sorted-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);        
    }

    public ListNode mergeHelper(ListNode[] lists, int start, int end){

        if (end < start){
            return null;
        }
        if (start == end) {
            return lists[start];
        }

        int mid = start + ((end - start))/2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (left != null && right != null){
            if (left.val <= right.val){
                temp.next = left;
                left = left.next;
            }
            else {
                temp.next = right;
                right= right.next;
            }
            temp = temp.next;
        }

        while (left != null){
            temp.next = left; 
            temp = temp.next;
            left = left.next;
        }
        while (right != null){
            temp.next = right; 
            temp = temp.next;
            right = right.next;
        }
        return head.next;
    }
}