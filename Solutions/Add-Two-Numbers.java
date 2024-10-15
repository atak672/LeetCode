// https://leetcode.com/problems/add-two-numbers

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
class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // Highest is 19
        // Value put is 9, remainder is 1. Can do 19 / 10 = 1
        
        ListNode head = new ListNode(-1); 
        ListNode temp = head; 
        
        int carry = 0; 
        
        while (l1 != null || l2 != null || carry == 1){
            int valOne = 0;
            int valTwo = 0; 

            if (l1 != null){
                valOne = l1.val;
                l1 = l1.next; 
            }
            
            if (l2 != null){
                valTwo = l2.val;
                l2 = l2.next; 
            }
            
            int newVal = valOne + valTwo + carry;
            carry = newVal / 10; 
            temp.next = new ListNode(newVal % 10);
            temp = temp.next;
        }
    
    return head.next; 
    }
}