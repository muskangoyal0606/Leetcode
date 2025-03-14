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
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode[] dfs(TreeNode node) {
        if (node == null) return new TreeNode[]{null, null};

        TreeNode[] left = dfs(node.left);
        TreeNode[] right = dfs(node.right);

        node.left = null;  // Set left child to null as per the requirements
        TreeNode end = node;

        if (left[0] != null) {
            end.right = left[0];
            end = left[1];
        }

        if (right[0] != null) {
            end.right = right[0];
            end = right[1];
        }

        return new TreeNode[]{node, end};
    }
}