// https://leetcode.com/problems/palindrome-linked-list

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
class PalindromeLinkedListSolution {
    public boolean isPalindrome(ListNode head) {

        // Palindrome reads same forward as backwords
        // Can do this in O(N) ofc

        ListNode slow = head; 
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }

        // Slow is now at the middle of the list 
        ListNode reversed = reverseLinkedList(slow);

        while (reversed != null){
            if (reversed.val != head.val){
                return false;
            }
            reversed = reversed.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseLinkedList(ListNode head){

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