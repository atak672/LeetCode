// https://leetcode.com/problems/merge-two-sorted-lists

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
class MergeTwoSortedListsSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Head of new list (dummy node) and temp will be used to help splice
        ListNode head = new ListNode(-1, null);
        ListNode temp = head;

        while (list1 != null && list2 != null){
            if (list1.val >= list2.val){
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
            else {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
        }

        while (list1 != null){
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }
        while (list2 != null){
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }
        return head.next;
    }
}