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
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> store = new ArrayList<>();
        helper(root,0,result);
        int sum = 0;
        int max = 0;
        for(List<Integer> a: result){
            for(int n : a){
                sum = sum +n;
                
            }
            store.add(sum);
            sum =0;
        }
        int maxSum = store.get(0);
        int index = 0;
        for (int i = 1; i < store.size(); i++) {
            if (store.get(i) > maxSum) {
                maxSum = store.get(i);
                index = i;
            }
        }
        return index +1;
        
    }
    public void helper(TreeNode root, int level, List<List<Integer>> result){
        if(root==null){
            return;
        }
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left,level+1,result);
        helper(root.right,level+1,result);
    }
}