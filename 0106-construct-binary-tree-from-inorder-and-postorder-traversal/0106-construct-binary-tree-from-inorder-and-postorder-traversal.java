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
    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = inorder.length-1;

        // Store value -> index from inorder for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
        
    }
    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right) return null;

        // Pick current root from preorder
        int rootVal = postorder[preorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find index of root in inorder
        int rootIndex = inorderIndexMap.get(rootVal);

        // Recursively build left & right subtrees
        root.right = build(postorder, rootIndex + 1, right);
        root.left = build(postorder, left, rootIndex - 1);
        

        return root;
    }
}