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
        helper(root, result,0);
        return result.get(result.size()-1);
    }
    public void helper(TreeNode root, List<Integer> result,int level){
        if(root==null){
            return;
        }
        if(level == result.size()){
            result.add(root.val);
        }
        helper(root.left,result,level+1);
        helper(root.right,result,level+1);
        
        
    }
}