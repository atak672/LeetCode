// https://leetcode.com/problems/reverse-linked-list

class ReverseLinkedListSolution {
    public ListNode reverseList(ListNode head) {

        // 1 --> 2 ---> 3 --> null
        // 3 --> 2 ---> 1 --> null

        // For this one, we essentially want to construct the reversed list
        // via a new pointer that builds end to front
        // The end of the new list will start as null, we traverse
        // the input list in order, and use this order to build back to front
        // Current node at head becomes our first node, we use a temp to keep the
        // .next field. We utilize our prev to keep track of growing list. 
        // the .next field will equal current tail, update head to temp value

        // head of growing reversed list, grows list back to front
        // Will be using head and head.next each iteration, so cannot be null
        ListNode prev = null; 
        while (head != null){
            // temp var to preserve.next field and list integrity
            ListNode temp = head.next; // head != null so this is okay
            head.next = prev; // Add new node, growing back to front
            // Prev stores current growing list
            prev = head; // node attached to list, becomes new head to preserve order
            head = temp;
        }
        return prev;
    }
}

