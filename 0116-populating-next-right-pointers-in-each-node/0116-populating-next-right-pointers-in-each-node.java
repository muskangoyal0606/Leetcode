/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {

        if (root == null) return null;
        Node leftmost = root; // Start with the root

        while (leftmost.left != null) { // Traverse levels

            Node curr = leftmost;

            while (curr != null) { // Traverse nodes in the current level

                curr.left.next = curr.right; // Connect left -> right

                
                if (curr.next != null) {

                    curr.right.next = curr.next.left; // Connect right -> next level left

                }  

                curr = curr.next; // Move to next node in level

            }


            leftmost = leftmost.left; // Move to next level

        }

        return root;

    }

}