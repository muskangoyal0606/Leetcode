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
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftView(root, result, 0);
        return result.get(result.size()-1);
    }
    public void leftView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) return;

        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        leftView(curr.left, result, currDepth + 1);
        leftView(curr.right, result, currDepth + 1);
    }
}