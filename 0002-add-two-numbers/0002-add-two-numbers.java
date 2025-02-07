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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy node to track head of result list
        ListNode current = dummy;  // Pointer for result list
        int carry = 0;  // Variable to store carry

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;  // Add value from l1
                l1 = l1.next;    // Move to next node
            }
            if (l2 != null) {
                sum += l2.val;  // Add value from l2
                l2 = l2.next;    // Move to next node
            }
            
            carry = sum / 10;  // Compute carry
            current.next = new ListNode(sum % 10);  // Store the single digit in result
            current = current.next;  // Move pointer forward
        }

        return dummy.next;  // Return head of result list (ignoring dummy node)
    }
}
