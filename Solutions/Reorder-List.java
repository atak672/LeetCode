// https://leetcode.com/problems/reorder-list

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
class ReorderListSolution {
    public void reorderList(ListNode head) {
        if (head == null){
            return; 
        }
        // Reverse the second half of the linkedlist (half excluding first value)

        ListNode slow = head.next; 
        ListNode fast = slow; 

        while (fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        
        // Slow pointer is now at the middle of list, lets reverse it
        ListNode reverseList = reverseLinkedList(slow);

        // Now we need to build the desired list
        ListNode temp = head; 
        head = head.next; 
        
        // Choose from reversed list first, then existing until reverse is null (this will be the halfway point we found in reversed order)
        // Reversed will be l1
        // head.next will be l2, we build from existing head temp
        while (reverseList != null){
            temp.next = reverseList; 
            temp = temp.next;
            reverseList = reverseList.next;
            temp.next = head; 
            head = head.next; 
            temp = temp.next;
        }
         // For even it will be fine, for odd, will create a cycle at the end to last node, just reset end to null to avoid before return;
        temp.next = null;
        return; 
    }



    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next; 
            head.next = prev; 
            prev = head; 
            head = temp;
        }
        return prev; 
    }
}