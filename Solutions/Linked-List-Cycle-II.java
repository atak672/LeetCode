// https://leetcode.com/problems/linked-list-cycle-ii

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycleIISolution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head; 
        ListNode fast = head; 

        while (fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
            if (slow == fast){
                slow = head; 
                while (slow != fast){
                    slow = slow.next; 
                    fast = fast.next; 
                }
                return fast;
            }
        }
        return null; 
        
    }
}