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
    public int minDiffInBST(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        inOrder(root, a);

        // Ensure there are at least two elements to compare
        if (a.size() < 2) {
            return -1; // Or any other meaningful default value
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < a.size(); i++) {
            minDiff = Math.min(minDiff, a.get(i) - a.get(i - 1));
        }

        return minDiff;
    }

    public void inOrder(TreeNode root, List<Integer> a) {
        if (root == null) {
            return;
        }
        inOrder(root.left, a);
        a.add(root.val);
        inOrder(root.right, a);
    }
}