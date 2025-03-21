/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private TreeNode first, middle, last, prev;

    private void inorder(TreeNode root) {
        if (root == null) return;

        // Traverse left subtree
        inorder(root.left);

        // Detect swapped nodes
        if (prev != null && root.val < prev.val) {
            // If this is the first violation, mark "first" and "middle"
            if (first == null) {
                first = prev;
                middle = root;
            } 
            // If this is the second violation, mark "last"
            else {
                last = root;
            }
        }
        
        prev = root; // Mark current node as previous

        // Traverse right subtree
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        // Perform inorder traversal to find swapped nodes
        inorder(root);

        // Swap values of misplaced nodes
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } 
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}