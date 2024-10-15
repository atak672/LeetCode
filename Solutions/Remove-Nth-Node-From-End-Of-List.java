// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
class RemoveNthNodeFromEndOfListSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }

        // if [1, 2] and n = 2 -- we want to remove 1
        // Edge case is if the size of list is equal to n
        // But this just means the gap will be mull 

        ListNode ptr1 = head; 
        ListNode ptr2 = head; 


        for (int i = 0; i < n; i++){
            ptr2 = ptr2.next; 
        }
        if (ptr2 == null){
            return head.next; 
        }


        while (ptr2.next != null){
            ptr2 = ptr2.next; 
            ptr1 = ptr1.next;
        }

        ptr1.next = ptr1.next.next;
        return head;
    }
}