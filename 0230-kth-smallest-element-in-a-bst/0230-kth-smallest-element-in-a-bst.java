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
class Solution {
    int count = 0;    // Counter to track the number of visited nodes
    int result = -1;  // Variable to store the kth smallest value

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) return;

        inorderTraversal(node.left, k);  // Traverse left subtree

        count++;  // Increment counter when a node is visited
        if (count == k) {
            result = node.val;  // Found the kth smallest element
            return;             // Stop traversal early
        }

        inorderTraversal(node.right, k); // Traverse right subtree
    }
}

