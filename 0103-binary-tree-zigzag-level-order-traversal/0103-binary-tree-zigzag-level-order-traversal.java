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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root,0,result);
        return result;
    }
    public void helper(TreeNode root, int level, List<List<Integer>> result){
        if(root==null){
            return;
        }
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        if(level % 2 != 0){
            result.get(level).add(0,root.val);
        

        }else{
        result.get(level).add(root.val);
        
        }
        helper(root.left,level+1,result);
        helper(root.right,level+1,result);
        
    }
}