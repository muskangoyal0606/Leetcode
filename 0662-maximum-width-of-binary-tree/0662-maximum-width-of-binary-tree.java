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
    // Function to calculate the maximum width of the binary tree
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>(); // Pair stores Node and its index
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int firstIndex = queue.peek().index;  // Index of the first node in the current level
            int lastIndex = queue.peek().index;   // Default last index

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int currentIndex = current.index;

                // Track the last node's index for width calculation
                lastIndex = currentIndex;

                // Enqueue child nodes with their respective indices
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * currentIndex));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * currentIndex + 1));
                }
            }

            // Calculate the width of the current level
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }
}
class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
