/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            // If no child, move to next node
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }

            // Find the tail of the child list
            Node child = curr.child;
            Node tail = child;
            while (tail.next != null) {
                tail = tail.next;
            }

            // Connect tail to next node (if exists)
            if (curr.next != null) {
                tail.next = curr.next;
                curr.next.prev = tail;
            }

            // Connect child to curr.next
            curr.next = child;
            child.prev = curr;

            // Remove child reference
            curr.child = null;

            // Move to next node
            curr = curr.next;
        }
        return head;
    }
}