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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);
        return sortedList.get(k - 1); // Since k is 1-indexed
    }

    // Helper method for inorder traversal
    private void inorderTraversal(TreeNode node, List<Integer> sortedList) {
        if (node == null) return;
        
        inorderTraversal(node.left, sortedList); // Traverse left subtree
        sortedList.add(node.val);               // Add root value
        inorderTraversal(node.right, sortedList); // Traverse right subtree
    }
}
