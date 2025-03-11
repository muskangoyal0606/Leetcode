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
    private int leftmostValue;
    private int maxDepth = -1;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return leftmostValue;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // If this is the first node encountered at this depth, update leftmostValue
        if (depth > maxDepth) {
            maxDepth = depth;
            leftmostValue = node.val;
        }

        // Traverse left first to prioritize leftmost nodes
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}