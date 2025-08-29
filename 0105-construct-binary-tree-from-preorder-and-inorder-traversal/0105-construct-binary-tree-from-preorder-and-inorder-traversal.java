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
    private Map<Integer,Integer> hm;
    private int preorderindex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm = new HashMap<>();
        preorderindex =0;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int left, int right){
        if(left>right) return null;

        int rootval = preorder[preorderindex++];
        TreeNode root = new TreeNode(rootval);
        int ri = hm.get(rootval);

        root.left = build(preorder,left,ri-1);
        root.right = build(preorder,ri+1,right);

        return root;

    }
}