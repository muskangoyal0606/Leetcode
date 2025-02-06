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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: if left == right, no need to reverse anything
        if (left == right) {
            return head;
        }
        
        // Create a dummy node to simplify edge cases like when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 1: Traverse to the node just before the 'left' position
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; ++i) {
            prev = prev.next;
        }
        
        // Step 2: Identify the node where reversal starts
        ListNode start = prev.next;  // The first node in the sublist to be reversed
        ListNode then = start.next;  // The node after 'start'
        
        // Step 3: Reverse the sublist from 'left' to 'right'
        for (int i = 0; i < right - left; ++i) {
            start.next = then.next;  // Detach 'then' from its current position
            then.next = prev.next;   // Insert 'then' at the beginning of the reversed section
            prev.next = then;        // Update 'prev.next' to point to the new head of the reversed section
            then = start.next;       // Move 'then' to the next node to process
        }
        
        // Step 4: Return the modified list starting from dummy.next
        return dummy.next;
    }
}