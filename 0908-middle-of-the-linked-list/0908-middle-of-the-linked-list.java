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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp!= null){
            temp = temp.next;
            count ++;
        }
        int middle = count/2;
        ListNode start = head;
        int i=0;
        while(i!=middle){
         start= start.next;
         i++;
        }
        head = start;
        return head;
    }
}