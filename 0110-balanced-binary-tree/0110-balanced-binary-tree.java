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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0; // Base case: empty tree has height 0

        int lh = height(root.left);
        if (lh == -1) return -1; // Left subtree is unbalanced

        int rh = height(root.right);
        if (rh == -1) return -1; // Right subtree is unbalanced

        if (Math.abs(lh - rh) > 1) return -1; // Current tree is unbalanced

        return Math.max(lh, rh) + 1; // Return correct height
    }
}