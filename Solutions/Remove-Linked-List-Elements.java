// https://leetcode.com/problems/remove-linked-list-elements

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
class RemoveLinkedListElementsSolution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = head; 
        if (head == null){
            return head;
        }
        if (head.next == null){
             if(head.val == val){
                return head.next; 
             }
             return head; 
        }

        while (head.next != null){
            if (head.next.val == val ){
                head.next = head.next.next;
                continue;
            }
            if (head.next == null){
                if(head.val == val){
                    return head.next; 
                 }
                 return root; 
            }
            head = head.next; 

        }
        if (root.val == val){
            return root.next; 
        }

        return root; 
    }
}