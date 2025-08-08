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
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        
        check(root);
        return isBalanced;
    }
    public int check(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = check(root.left);
        int rh = check(root.right);

        if(Math.abs(lh-rh)>1){
            isBalanced = false;
        }

        return Math.max(lh,rh)+1;
    }

    
}