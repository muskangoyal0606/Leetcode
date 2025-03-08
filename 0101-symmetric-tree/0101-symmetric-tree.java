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
    public boolean isSymmetric(TreeNode root) {
         // If tree is empty, it's symmetric
        if (root == null)
            return true;

        // Check if the left and right subtrees are mirrors of each other
        return isMirror(root.left, root.right);
    }
    public static boolean isMirror(TreeNode leftSub, TreeNode rightSub) {
      
        // Both are null, so they are mirror images
        if (leftSub == null && rightSub == null)
            return true;

        // One of them is null, so they aren't mirror images
        if (leftSub == null || rightSub == null 
                        || leftSub.val != rightSub.val)
            return false;

        // Check if the subtrees are mirrors
        return isMirror(leftSub.left, rightSub.right) && 
               isMirror(leftSub.right, rightSub.left);
    }
}