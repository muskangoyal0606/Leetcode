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
    public TreeNode sortedArrayToBST(int[] nums) {

        return constructbst(nums,0,nums.length-1);
    }
    public TreeNode constructbst(int[] nums, int start, int end){
        if(end < start){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode midy = new TreeNode(nums[mid]);
        midy.left = constructbst(nums,start,mid-1);
        midy.right = constructbst(nums,mid+1,end);
        return midy;

    }
}